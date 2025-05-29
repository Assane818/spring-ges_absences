package com.ism.gestion_absences.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Etudiant;

public interface EtudiantRepository extends MongoRepository<Etudiant, String> {
    Page<Etudiant> findAll(Pageable pageable);
    Etudiant findEtudiantByMatricule(String matricule);
}
