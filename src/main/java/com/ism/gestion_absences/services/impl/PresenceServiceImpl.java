package com.ism.gestion_absences.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.data.repository.PresenceRepository;
import com.ism.gestion_absences.services.PresenceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PresenceServiceImpl implements PresenceService {

    private final PresenceRepository presenceRepository;

    @Override
    public Page<Presence> getAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    @Override
    public List<Presence> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Presence create(Presence t) {
        return presenceRepository.save(t);
    }

    @Override
    public Presence update(String id, Presence t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Presence getById(String id) {
        return presenceRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<Presence> getByType(TypePresence type, Pageable pageable) {
        return presenceRepository.findByTypePresence(type, pageable);
    }

    @Override
    public Page<Presence> getByEtudiantId(String etudiantId, TypePresence type, Pageable pageable) {
        return presenceRepository.findByEtudiantIdAndTypePresence(etudiantId, type, pageable);
    }

}
