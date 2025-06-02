package com.ism.gestion_absences.web.controllers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Justificatif;
import com.ism.gestion_absences.services.JustificatifService;
import com.ism.gestion_absences.utils.mappers.JustificatifMapper;
import com.ism.gestion_absences.web.controllers.JustificatifWebController;
import com.ism.gestion_absences.web.dto.Request.JustificatifUpdateRequest;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JustificatifWebControllerImpl implements JustificatifWebController {

    private final JustificatifService justificatifService;
    private final JustificatifMapper justificatifMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAllPaginate(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        Justificatif justificatif = justificatifService.getById(id);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, justificatifMapper.toJustificatifOneWebResponse(justificatif), "JustificatifOneWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(JustificatifUpdateRequest object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(String id, @RequestBody JustificatifUpdateRequest object, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fields = bindingResult.getFieldErrors();
            fields.forEach(fieldError->errors.put(fieldError.getField().toLowerCase(), fieldError.getDefaultMessage()));
            return new ResponseEntity<>(RestResponse.response(HttpStatus.BAD_REQUEST, errors, "Map<String, String>"), HttpStatus.BAD_REQUEST);
        } else {
            var justificatif = justificatifMapper.toEntity(object);
            var just = justificatifService.update(id, justificatif);
            if (just == null) {
                return new ResponseEntity<>(RestResponse.response(HttpStatus.NOT_FOUND, null, "CategorieAllResponse"), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(RestResponse.response(HttpStatus.ACCEPTED, justificatifMapper.toJustificatifOneWebResponse(just), "CategorieAllResponse"), HttpStatus.ACCEPTED);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
