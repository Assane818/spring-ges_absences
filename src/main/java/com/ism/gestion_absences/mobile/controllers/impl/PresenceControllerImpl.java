package com.ism.gestion_absences.mobile.controllers.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.CoursClasse;
import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.mobile.controllers.PresenceController;
import com.ism.gestion_absences.mobile.dto.Response.EtudiantAndPresencesResponse;
import com.ism.gestion_absences.mobile.dto.Response.EtudiantOneResponse;
import com.ism.gestion_absences.mobile.dto.Response.PresenceAllResponse;
import com.ism.gestion_absences.services.CoursClasseService;
import com.ism.gestion_absences.services.EtudiantService;
import com.ism.gestion_absences.services.PresenceService;
import com.ism.gestion_absences.utils.mappers.EtudiantMapper;
import com.ism.gestion_absences.utils.mappers.PresenceMapper;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PresenceControllerImpl implements PresenceController {

    private final PresenceService presenceService;
    private final EtudiantService etudiantService;
    private final PresenceMapper presenceMapper;
    private final EtudiantMapper etudiantMapper;
    private final CoursClasseService coursClasseService;

    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        List<Presence> pressences = presenceService.getAll();
        List<PresenceAllResponse> presencesReponse = pressences.stream().map(presenceMapper::toPresenceAllReponse).toList();
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, presencesReponse, "PresenceAllResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        var presence = presenceService.getById(id);
        var presenceReponse = presenceMapper.toPresenceOneResponse(presence);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, presenceReponse, "PresenceOneResponse"),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(Presence object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(String id, Presence object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByType(String type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Presence> pressences = presenceService.getByType(TypePresence.valueOf(type), pageable);
        Page<PresenceAllResponse> presencesReponse = pressences.map(presenceMapper::toPresenceAllReponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(),
                new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(),
                presencesReponse.isFirst(), presencesReponse.isLast(), "ArticleAllResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByEtudiantId(String etudiantId, TypePresence type) {
        var etudiant = etudiantService.getById(etudiantId);
        if (etudiant == null) {
            return new ResponseEntity<>(
                    RestResponse.response(HttpStatus.NOT_FOUND, "Etudiant not found", "ErrorResponse"),
                    HttpStatus.NOT_FOUND);
        }
        List<Presence> pressences = presenceService.getByEtudiantId(etudiantId, type);
        EtudiantOneResponse etudiantResponse = etudiantMapper.toEtudiantOneResponse(etudiant);
        List<PresenceAllResponse> presencesReponse = pressences.stream().map(presenceMapper::toPresenceAllReponse).toList();
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, new EtudiantAndPresencesResponse(etudiantResponse, presencesReponse), "EtudiantAndPresencesResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> pointage(String matricule) {
        var etudiant = etudiantService.getByMatricule(matricule);
        if (etudiant == null) {
            return new ResponseEntity<>(
                    RestResponse.response(HttpStatus.NOT_FOUND, "Etudiant not found", "ErrorResponse"),
                    HttpStatus.NOT_FOUND);
        }

        var coursClasses = coursClasseService.getByClasseId(etudiant.getClasse().getId());
        Presence presence = new Presence();
        presence.setEtudiant(etudiant);
            // Récupérer les cours d’aujourd’hui
            List<CoursClasse> coursDuJour = coursClasses.stream()
                    .filter(cc -> LocalDate.now().equals(cc.getCours().getDate()))
                    .collect(Collectors.toList());

            // Chercher le cours le plus proche ou en cours
            CoursClasse coursCible = coursDuJour.stream()
                    .filter(cc -> !LocalTime.now().isAfter(cc.getCours().getHeureFin()))
                    .min(Comparator.comparing(cc -> cc.getCours().getHeureDebut()))
                    .orElse(null);

            if (coursCible != null) {
                var heureDebut = coursCible.getCours().getHeureDebut();
                var heureFin = coursCible.getCours().getHeureFin();
                var now = LocalTime.now();
                if (!etudiant.isStatus()) {
                    presence.setTypePresence(TypePresence.ABSENT);
                } else if (now.isAfter(heureDebut) && now.isBefore(heureFin)) {
                    if (now.isBefore(heureDebut.plusMinutes(15))) {
                        presence.setTypePresence(TypePresence.PRESENT);
                    } else {
                        presence.setTypePresence(TypePresence.RETARD);
                    }
                } else if (now.isBefore(heureDebut)) {
                    presence.setTypePresence(TypePresence.PRESENT);
                } else {
                    presence.setTypePresence(TypePresence.ABSENT);
                }
                presence.setCours(coursCible.getCours());
            } else {
                return new ResponseEntity<>(
                        RestResponse.response(HttpStatus.OK, null, "PresenceOneResponse"),
                        HttpStatus.OK);
        }
        presence.setDate(LocalDate.now());

        presenceService.create(presence);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.CREATED, presenceMapper.toPresenceOneResponse(presence), "PresenceOneResponse"),
                HttpStatus.CREATED);
    }

}
