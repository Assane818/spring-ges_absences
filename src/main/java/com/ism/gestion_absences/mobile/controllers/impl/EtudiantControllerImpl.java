package com.ism.gestion_absences.mobile.controllers.impl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.mobile.controllers.EtudiantController;
import com.ism.gestion_absences.services.EtudiantService;
import com.ism.gestion_absences.utils.mappers.EtudiantMapper;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EtudiantControllerImpl implements EtudiantController {
    private final EtudiantService etudiantService;
    private final EtudiantMapper etudiantMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        Etudiant etudiant = etudiantService.getById(id);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, etudiantMapper.toEtudiantOneResponse(etudiant), "EtudiantOneResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(Etudiant object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(String id, Etudiant object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByMatricule(String matricule) {
        var etudiant = etudiantService.getByMatricule(matricule);
        if (etudiant == null) {
            return new ResponseEntity<>(RestResponse.response(HttpStatus.NOT_FOUND, null, "EtudiantOneResponse"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, etudiantMapper.toEtudiantOneResponse(etudiant), "EtudiantOneResponse"), HttpStatus.OK);
    }

}
