package com.ism.gestion_absences.services.impl;

import java.time.LocalDate;
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
        return presenceRepository.findAll(pageable);
    }

    @Override
    public List<Presence> getAll() {
        return presenceRepository.findAll();
    }

    @Override
    public Presence create(Presence t) {
        return presenceRepository.save(t);
    }

    @Override
    public Presence update(String id, Presence t) {
        Presence presence = presenceRepository.findById(id).orElse(null);
        if (presence != null) {
            presence.setAdmin(t.getAdmin());
            presence.setJustificatif(t.getJustificatif());

        }
        return presenceRepository.save(presence);
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

    @Override
    public List<Presence> getByEtudiantId(String etudiantId, TypePresence type) {
        return presenceRepository.findByEtudiantIdAndTypePresence(etudiantId, type);
    }

    @Override
    public Page<Presence> getByCoursIdAndTypePresence(String coursId, TypePresence type, Pageable pageable) {
        return presenceRepository.findByCoursIdAndTypePresence(coursId, type, pageable);
    }

    @Override
    public Page<Presence> getByTypePresenceAndDate(LocalDate date, TypePresence type, Pageable pageable) {
        return presenceRepository.findByTypePresenceAndDate(type, date, pageable);
    }

    @Override
    public Presence getByEtudiantIdAndCoursId(String etudiantId, String coursId) {
        return presenceRepository.findByEtudiantIdAndCoursId(etudiantId, coursId);
    }

    @Override
    public Page<Presence> getByTypePresenceAndDateAndCoursId(TypePresence type, String coursId, LocalDate date, Pageable pageable) {
        return presenceRepository.findByTypePresenceAndCoursIdAndDate(type, coursId, date, pageable);
    }

}
