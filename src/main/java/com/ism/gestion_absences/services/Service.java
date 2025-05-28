package com.ism.gestion_absences.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public interface Service<T> {
    Page<T> getAllPaginate(Pageable pageable);
    List<T> getAll();
    T create(T t);
    T update(Long id, T t);
    T getById(Long id);
    boolean delete(Long id);
}
