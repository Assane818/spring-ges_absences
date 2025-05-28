package com.ism.gestion_absences.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Justificatif;

public interface JustificatifRepository extends MongoRepository<Justificatif, String> {
    Page<Justificatif> findAll(Pageable pageable);
}
