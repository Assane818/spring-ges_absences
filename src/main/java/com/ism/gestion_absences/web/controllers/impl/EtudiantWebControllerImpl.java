package com.ism.gestion_absences.web.controllers.impl;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.services.EtudiantService;
import com.ism.gestion_absences.utils.mappers.EtudiantMapper;
import com.ism.gestion_absences.web.controllers.EtudiantWebController;
import com.ism.gestion_absences.web.dto.Response.EtudiantAllWebResponse;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EtudiantWebControllerImpl implements EtudiantWebController {

    private final EtudiantService etudiantService;
    private final EtudiantMapper etudiantMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAllPaginate(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Etudiant> etudiants = etudiantService.getAllPaginate(pageable);
        Page<EtudiantAllWebResponse> etudiantResponse = etudiants.map(etudiantMapper::toEtudiantAllResponse);
        var totalPages = etudiantResponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, etudiantResponse.getContent(),
                new int[totalPages], etudiantResponse.getNumber(), totalPages, etudiantResponse.getTotalElements(),
                etudiantResponse.isFirst(), etudiantResponse.isLast(), "EtudiantAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
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
    public ResponseEntity<Map<String, Object>> getByClasseId(String classeId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Etudiant> etudiants = etudiantService.getByClasseId(classeId, pageable);
        Page<EtudiantAllWebResponse> etudiantResponse = etudiants.map(etudiantMapper::toEtudiantAllResponse);
        var totalPages = etudiantResponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, etudiantResponse.getContent(),
                new int[totalPages], etudiantResponse.getNumber(), totalPages, etudiantResponse.getTotalElements(),
                etudiantResponse.isFirst(), etudiantResponse.isLast(), "EtudiantAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByStatus(String status, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        boolean statusBoolean = Boolean.parseBoolean(status);
        Page<Etudiant> etudiants = etudiantService.getByStatus(statusBoolean, pageable);
        Page<EtudiantAllWebResponse> etudiantResponse = etudiants.map(etudiantMapper::toEtudiantAllResponse);
        var totalPages = etudiantResponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, etudiantResponse.getContent(),
                new int[totalPages], etudiantResponse.getNumber(), totalPages, etudiantResponse.getTotalElements(),
                etudiantResponse.isFirst(), etudiantResponse.isLast(), "ArticleAllResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByClasseAndStatus(String classeId, String status, int page,
            int size) {
        Pageable pageable = PageRequest.of(page, size);
        boolean statusBoolean = Boolean.parseBoolean(status);
        Page<Etudiant> etudiants = etudiantService.getByClasseIdAndStatus(classeId, statusBoolean, pageable);
        Page<EtudiantAllWebResponse> etudiantResponse = etudiants.map(etudiantMapper::toEtudiantAllResponse);
        var totalPages = etudiantResponse.getTotalPages();
        return new ResponseEntity<>(RestResponse.responsePaginate(HttpStatus.OK, etudiantResponse.getContent(),
                new int[totalPages], etudiantResponse.getNumber(), totalPages, etudiantResponse.getTotalElements(),
                etudiantResponse.isFirst(), etudiantResponse.isLast(), "EtudiantAllWebResponse"), HttpStatus.OK);
    }
    
}
