package com.ism.gestion_absences.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ism.gestion_absences.data.entities.CoursClasse;
import com.ism.gestion_absences.data.repository.CoursClasseRepository;
import com.ism.gestion_absences.services.CoursClasseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoursClasseServiceImpl implements CoursClasseService {

    private final CoursClasseRepository coursClasseRepository;
    @Override
    public Page<CoursClasse> getAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    @Override
    public List<CoursClasse> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public CoursClasse create(CoursClasse t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CoursClasse update(String id, CoursClasse t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CoursClasse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<CoursClasse> getByClasseId(String classeId) {
        return coursClasseRepository.findByClasseId(classeId);
    }

}
