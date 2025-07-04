package com.ism.gestion_absences.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ism.gestion_absences.data.entities.Classe;
import com.ism.gestion_absences.data.repository.ClasseRepository;
import com.ism.gestion_absences.services.ClasseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;
    @Override
    public Page<Classe> getAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    @Override
    public List<Classe> getAll() {
        return classeRepository.findAll();
    }

    @Override
    public Classe create(Classe t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Classe update(String id, Classe t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Classe getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
