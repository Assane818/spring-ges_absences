package com.ism.gestion_absences.web.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Classe;
import com.ism.gestion_absences.services.ClasseService;
import com.ism.gestion_absences.utils.mappers.ClasseMapper;
import com.ism.gestion_absences.web.controllers.ClasseWebController;
import com.ism.gestion_absences.web.dto.Response.ClasseAllWebResponse;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClasseWebControllerImpl implements ClasseWebController {

    private final ClasseService classeService;
    private final ClasseMapper classeMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        List<Classe> classes = classeService.getAll();
        List<ClasseAllWebResponse> classesResponse = classes.stream().map(classeMapper::toClasseAllWebResponse).toList();
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, classesResponse, "ClasseAllWebResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAllPaginate(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(Classe object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(String id, Classe object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
