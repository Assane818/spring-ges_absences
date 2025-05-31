package com.ism.gestion_absences.mobile.controllers.impl;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.mobile.controllers.PresenceController;
import com.ism.gestion_absences.mobile.dto.Response.EtudiantAndPresencesResponse;
import com.ism.gestion_absences.mobile.dto.Response.EtudiantOneResponse;
import com.ism.gestion_absences.mobile.dto.Response.PresenceAllResponse;
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
    @Override
    public ResponseEntity<Map<String, Object>> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Presence> pressences = presenceService.getAllPaginate(pageable);
        Page<PresenceAllResponse> presencesReponse = pressences.map(presenceMapper::toPresenceAllReponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(), new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(), presencesReponse.isFirst(), presencesReponse.isLast(), "ArticleAllResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        var presence = presenceService.getById(id);
        var presenceReponse = presenceMapper.toPresenceOneResponse(presence);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, presenceReponse, "ArticleOneResponse"), HttpStatus.OK);
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
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(), new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(), presencesReponse.isFirst(), presencesReponse.isLast(), "ArticleAllResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByEtudiantId(String etudiantId, TypePresence type, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var etudiant = etudiantService.getById(etudiantId);
        if (etudiant == null) {
            return new ResponseEntity<>(RestResponse.response(HttpStatus.NOT_FOUND, "Etudiant not found", "ErrorResponse"), HttpStatus.NOT_FOUND);
        } 
        Page<Presence> pressences = presenceService.getByEtudiantId(etudiantId, type, pageable);
        EtudiantOneResponse etudiantResponse = etudiantMapper.toEtudiantOneResponse(etudiant);
        Page<PresenceAllResponse> presencesReponse = pressences.map(presenceMapper::toPresenceAllReponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, new EtudiantAndPresencesResponse(etudiantResponse, presencesReponse.getContent()), new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(), presencesReponse.isFirst(), presencesReponse.isLast(), "ArticleAllResponse"), HttpStatus.OK);
    }
}
    
    

