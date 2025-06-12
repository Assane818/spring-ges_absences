package com.ism.gestion_absences.services.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.data.repository.EtudiantRepository;
import com.ism.gestion_absences.services.EtudiantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    @Override
    public Page<Etudiant> getAllPaginate(Pageable pageable) {
        return etudiantRepository.findAll(pageable);
    }

    @Override
    public List<Etudiant> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Etudiant create(Etudiant t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Etudiant update(String id, Etudiant t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Etudiant getById(String id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Etudiant getByMatricule(String matricule) {
        return etudiantRepository.findFirstByMatricule(matricule);
    }

    @Override
    public Page<Etudiant> getByClasseId(String classeId, Pageable pageable) {
        return etudiantRepository.findByClasseId(classeId, pageable);
    }

    @Override
    public Page<Etudiant> getByStatus(boolean status, Pageable pageable) {
        return etudiantRepository.findByStatus(status, pageable);
    }

    @Override
    public Page<Etudiant> getByClasseIdAndStatus(String classeId, boolean status, Pageable pageable) {
        return etudiantRepository.findByClasseIdAndStatus(classeId, status, pageable);
    }
    
}
