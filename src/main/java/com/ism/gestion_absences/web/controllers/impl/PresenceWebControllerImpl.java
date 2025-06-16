package com.ism.gestion_absences.web.controllers.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.services.PresenceService;
import com.ism.gestion_absences.utils.mappers.PresenceMapper;
import com.ism.gestion_absences.web.controllers.PresenceWebController;
import com.ism.gestion_absences.web.dto.Response.PresenceOneWebResponse;
import com.ism.gestion_absences.web.dto.Response.PresenseAllWebResponse;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PresenceWebControllerImpl implements PresenceWebController {

    private final PresenceService presenceService;
    private final PresenceMapper presenceMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAllPaginate(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        Presence presence = presenceService.getById(id);
        if (presence == null) {
            return new ResponseEntity<>(RestResponse.response(HttpStatus.NOT_FOUND, null, "PresenceOneWebResponse"), HttpStatus.NOT_FOUND);
        }
        PresenceOneWebResponse presenceResponse = presenceMapper.toPresenceOneWebResponse(presence);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, presenceResponse, "PresenceOneWebResponse"), HttpStatus.OK);
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
        Page<PresenseAllWebResponse> presencesReponse = pressences.map(presenceMapper::toPresenseAllWebResponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(),
                new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(),
                presencesReponse.isFirst(), presencesReponse.isLast(), "PresenseAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByCoursAndType(String type, String coursId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Presence> pressences = presenceService.getByCoursIdAndTypePresence(coursId, TypePresence.valueOf(type), pageable);
        Page<PresenseAllWebResponse> presencesReponse = pressences.map(presenceMapper::toPresenseAllWebResponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(),
                new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(),
                presencesReponse.isFirst(), presencesReponse.isLast(), "PresenseAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByTypeAndDate(String type, LocalDate date, int page, int size) {
        if (date == null) {
            date = LocalDate.now();
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Presence> pressences = presenceService.getByTypePresenceAndDate(date, TypePresence.valueOf(type), pageable);
        Page<PresenseAllWebResponse> presencesReponse = pressences.map(presenceMapper::toPresenseAllWebResponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(),
                new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(),
                presencesReponse.isFirst(), presencesReponse.isLast(), "PresenseAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByJustify(String justify, int page, int size) {
        //false
        Pageable pageable = PageRequest.of(page, size);
        Boolean isJustify = Boolean.parseBoolean(justify);
        List<Presence> allPresences = presenceService.getAll();
        List<Presence> filteredContent = new ArrayList<>();
        if (isJustify) {
            for (Presence presence : allPresences) {
                if (presence.getJustificatif() != null) {
                    filteredContent.add(presence);
                }
            }
        } else {
            for (Presence presence : allPresences) {
                if (presence.getJustificatif() == null) {
                    filteredContent.add(presence);
                }
            }
        }
        // List<Presence> filteredContent = allPresences.stream()
        //     .filter(p -> (p.getJustificatif() == null) == isJustify)
        //     .toList();
        Page<Presence> pressences = new PageImpl<>(filteredContent, pageable, filteredContent.size());
        Page<PresenseAllWebResponse> presencesReponse = pressences.map(presenceMapper::toPresenseAllWebResponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(),
                new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(),
                presencesReponse.isFirst(), presencesReponse.isLast(), "PresenseAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByTypeAndCoursAndDate(String type, String coursId, LocalDate date, int page, int size) {
        if (date == null) {
            date = LocalDate.now();
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Presence> pressences = presenceService.getByTypePresenceAndDateAndCoursId(TypePresence.valueOf(type), coursId, date, pageable);
        Page<PresenseAllWebResponse> presencesReponse = pressences.map(presenceMapper::toPresenseAllWebResponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(),
                new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(),
                presencesReponse.isFirst(), presencesReponse.isLast(), "PresenseAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByTypeAndCoursAndEtatAndDate(String type, String coursId, String etat,
            LocalDate date, int page, int size) {
        if (date == null) {
            date = LocalDate.now();
        }
        Boolean isJustify = Boolean.parseBoolean(etat);
        Pageable pageable = PageRequest.of(page, size);
        Page<Presence> allPresences = presenceService.getByTypePresenceAndDateAndCoursId(TypePresence.valueOf(type), coursId, date, pageable);
        List<Presence> filteredContent = allPresences.getContent().stream()
            .filter(p -> (p.getJustificatif() == null) == isJustify)
            .toList();
        Page<Presence> pressences = new PageImpl<>(filteredContent, pageable, filteredContent.size());
        Page<PresenseAllWebResponse> presencesReponse = pressences.map(presenceMapper::toPresenseAllWebResponse);
        var totalPages = presencesReponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, presencesReponse.getContent(),
                new int[totalPages], presencesReponse.getNumber(), totalPages, presencesReponse.getTotalElements(),
                presencesReponse.isFirst(), presencesReponse.isLast(), "PresenseAllWebResponse"), HttpStatus.OK);
    }

}
