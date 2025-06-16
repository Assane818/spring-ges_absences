package com.ism.gestion_absences.data.repository;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;

public interface PresenceRepository extends MongoRepository<Presence, String> {
    Page<Presence> findAll(Pageable pageable);
    Page<Presence> findByTypePresence(TypePresence type, Pageable pageable);
    List<Presence> findByEtudiantIdAndTypePresence(String etudiantId, TypePresence type);
    Page<Presence> findByEtudiantIdAndTypePresence(String etudiantId, TypePresence type, Pageable pageable);
    Page<Presence> findByCoursIdAndTypePresence(String coursId, TypePresence type, Pageable pageable);
    Page<Presence> findByTypePresenceAndCoursId(TypePresence type, String coursId, Pageable pageable);
    Page<Presence> findByTypePresenceAndDate(TypePresence type, LocalDate date, Pageable pageable);
    Presence findByEtudiantIdAndCoursId(String etudiantId, String coursId);
    Page<Presence> findByTypePresenceAndCoursIdAndDate(TypePresence type, String coursId, LocalDate date, Pageable pageable);    



}
