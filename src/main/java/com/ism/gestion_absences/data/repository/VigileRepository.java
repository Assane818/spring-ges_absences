package com.ism.gestion_absences.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Vigile;

public interface VigileRepository extends MongoRepository<Vigile, String> {

}
