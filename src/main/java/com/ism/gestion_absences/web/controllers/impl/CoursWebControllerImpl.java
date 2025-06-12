package com.ism.gestion_absences.web.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.services.CoursService;
import com.ism.gestion_absences.utils.mappers.CoursMapper;
import com.ism.gestion_absences.web.controllers.CoursWebController;
import com.ism.gestion_absences.web.dto.Response.CoursAllWebResponse;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CoursWebControllerImpl implements CoursWebController {

    private final CoursService coursService;
    private final CoursMapper coursMapper;
    @Override
    public ResponseEntity<Map<String, Object>> getAll() {
        var coursList = coursService.getAll();
        List<CoursAllWebResponse> coursResponse = coursList.stream().map(coursMapper::toCoursAllWebResponse).toList();
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, coursResponse, "CoursAllWebResponse"), HttpStatus.OK);
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
    public ResponseEntity<Map<String, Object>> create(Cours object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(String id, Cours object, BindingResult bindingResult) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> getCoursByDate(String date, int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCoursByDate'");
    }


}
