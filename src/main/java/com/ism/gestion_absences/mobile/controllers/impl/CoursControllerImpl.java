package com.ism.gestion_absences.mobile.controllers.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.mobile.controllers.CoursController;
import com.ism.gestion_absences.web.dto.Response.RestResponse;
import com.ism.gestion_absences.services.CoursClasseService;
import com.ism.gestion_absences.services.EtudiantService;
import com.ism.gestion_absences.utils.mappers.CoursMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CoursControllerImpl implements CoursController {

    private final CoursClasseService coursClasseService;
    private final EtudiantService etudiantService;
    private final CoursMapper coursMapper;
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
    public ResponseEntity<Map<String, Object>> getCoursByEtudiant(String id, LocalDate date) {
        List<Cours> coursList = new ArrayList<>();
        if (date == null) {
            date = LocalDate.now();
        }
        var etudiant = etudiantService.getById(id);
        if (etudiant == null) {
            return new ResponseEntity<>(
                    RestResponse.response(HttpStatus.NOT_FOUND, "Etudiant not found", "ErrorResponse"),
                    HttpStatus.NOT_FOUND);
        }
        var coursClasses = coursClasseService.getByClasseId(etudiant.getClasse().getId());
        for (var coursClasse : coursClasses) {
            if (coursClasse.getCours().getDate().equals(date)) {
                coursList.add(coursClasse.getCours());
            }
        }
        var coursResponse = coursList.stream().map(coursMapper::toCoursAllResponse).toList();
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, coursResponse, "CoursAllResponse"),
                HttpStatus.OK);
    }

}
