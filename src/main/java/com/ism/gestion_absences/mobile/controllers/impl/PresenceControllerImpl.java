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
import com.ism.gestion_absences.mobile.dto.Response.PresenceAllResponse;
import com.ism.gestion_absences.services.PresenceService;
import com.ism.gestion_absences.utils.mappers.PresenceMapper;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PresenceControllerImpl implements PresenceController {

    private final PresenceService presenceService;
    private final PresenceMapper presenceMapper;
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
    
    
}
