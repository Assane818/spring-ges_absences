package com.ism.gestion_absences.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Classe;

public interface ClasseRepository extends MongoRepository<Classe, String> {
    Page<Classe> findAll(Pageable pageable);
}
