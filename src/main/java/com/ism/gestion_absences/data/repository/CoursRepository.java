package com.ism.gestion_absences.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Cours;
import java.time.LocalDate;


public interface CoursRepository extends MongoRepository<Cours, String> {
    Page<Cours> findAll(Pageable pageable);
    Page<Cours> findByDate(LocalDate date, Pageable pageable);
    
}
