package com.ism.gestion_absences.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ism.gestion_absences.data.entities.Etudiant;

public interface EtudiantService extends Service<Etudiant> {
    Etudiant getByMatricule(String matricule);
    Page<Etudiant> getByClasseId(String classeId, Pageable pageable);
    Page<Etudiant> getByStatus(boolean status, Pageable pageable);
    Page<Etudiant> getByClasseIdAndStatus(String classeId, boolean status, Pageable pageable);
}
