package com.ism.gestion_absences.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;

public interface PresenceRepository extends MongoRepository<Presence, String> {
    Page<Presence> findAll(Pageable pageable);
    Page<Presence> findByTypePresence(TypePresence type, Pageable pageable);
    Page<Presence> findByEtudiantIdAndTypePresence(String etudiantId, TypePresence type, Pageable pageable);

}
