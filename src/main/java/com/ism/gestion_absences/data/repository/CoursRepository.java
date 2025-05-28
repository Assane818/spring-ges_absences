package com.ism.gestion_absences.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Cours;

public interface CoursRepository extends MongoRepository<Cours, String> {

}
