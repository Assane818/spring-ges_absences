package com.ism.gestion_absences.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;

public interface PresenceService extends Service<Presence> {
    Page<Presence> getByType(TypePresence type, Pageable pageable);
    List<Presence> getByEtudiantId(String etudiantId, TypePresence type);
    Page<Presence> getByEtudiantId(String etudiantId, TypePresence type, Pageable pageable);
    Page<Presence> getByCoursIdAndTypePresence(String coursId, TypePresence type, Pageable pageable);
    Page<Presence> getByTypePresenceAndDate(LocalDate date, TypePresence type, Pageable pageable);
    
}
