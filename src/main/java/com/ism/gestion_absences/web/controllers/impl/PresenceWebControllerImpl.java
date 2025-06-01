package com.ism.gestion_absences.web.controllers.impl;

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
import com.ism.gestion_absences.services.PresenceService;
import com.ism.gestion_absences.utils.mappers.PresenceMapper;
import com.ism.gestion_absences.web.controllers.PresenceWebController;
import com.ism.gestion_absences.web.dto.Response.PresenseAllWebResponse;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PresenceWebControllerImpl implements PresenceWebController {

    private final PresenceService presenceService;
    private final PresenceMapper presenceMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
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

}
