package com.ism.gestion_absences.mobile.controllers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.mobile.controllers.JustificatifController;
import com.ism.gestion_absences.mobile.dto.Request.JustificatifRequest;
import com.ism.gestion_absences.web.dto.Response.RestResponse;
import com.ism.gestion_absences.services.JustificatifService;
import com.ism.gestion_absences.services.PresenceService;
import com.ism.gestion_absences.utils.mappers.JustificatifMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JustificatifControllerImpl implements JustificatifController {

    private final JustificatifService justificatifService; 
    private final PresenceService presenceService;
    private final JustificatifMapper justificatifMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody JustificatifRequest object, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fields = bindingResult.getFieldErrors();
            fields.forEach(fieldError->errors.put(fieldError.getField().toLowerCase(), fieldError.getDefaultMessage()));
            return new ResponseEntity<>(RestResponse.response(HttpStatus.BAD_REQUEST, errors, "Map<String, String>"), HttpStatus.BAD_REQUEST);
        } else {
            var presence = presenceService.getById(object.getPresenceId());
            var just = justificatifService.create(justificatifMapper.toEntity(object));
            just.setPresence(presence);
            just.setValidation(false);
            return new ResponseEntity<>(RestResponse.response(HttpStatus.CREATED, justificatifMapper.toJustificatifOneResponse(just), "JustificatifOneResponse"), HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(String id, JustificatifRequest object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
