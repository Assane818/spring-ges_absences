package com.ism.gestion_absences.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Justificatif;

public interface JustificatifRepository extends MongoRepository<Justificatif, String> {
    // This interface will inherit all CRUD operations from MongoRepository
    // Additional custom query methods can be defined here if needed
}
