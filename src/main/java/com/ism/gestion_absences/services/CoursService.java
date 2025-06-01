package com.ism.gestion_absences.services;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ism.gestion_absences.data.entities.Cours;

public interface CoursService extends Service<Cours> {
    Page<Cours> getByDate(LocalDate date, Pageable pageable);
}
