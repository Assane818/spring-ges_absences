package com.ism.gestion_absences.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Presence;

public interface PresenceRepository extends MongoRepository<Presence, String> {
    // Additional query methods can be defined here if needed

}
