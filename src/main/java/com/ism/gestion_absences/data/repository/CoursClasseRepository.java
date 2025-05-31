package com.ism.gestion_absences.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.CoursClasse;

public interface CoursClasseRepository extends MongoRepository<CoursClasse, String> {
    List<CoursClasse> findByClasseId(String classeId);
}
