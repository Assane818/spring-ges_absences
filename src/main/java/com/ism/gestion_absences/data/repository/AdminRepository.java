package com.ism.gestion_absences.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ism.gestion_absences.data.entities.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>  {
    Page<Admin> findAll(Pageable pageable);
}
