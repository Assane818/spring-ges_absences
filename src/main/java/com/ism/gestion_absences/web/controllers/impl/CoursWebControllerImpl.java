package com.ism.gestion_absences.web.controllers.impl;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.web.controllers.CoursWebController;

public class CoursWebControllerImpl implements CoursWebController {

    @Override
    public ResponseEntity getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ResponseEntity create(Cours object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity update(String id, Cours object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getCoursByDate(String date, int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCoursByDate'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAllPaginate(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    

}
