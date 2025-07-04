package com.ism.gestion_absences.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T> {
    Page<T> getAllPaginate(Pageable pageable);
    List<T> getAll();
    T create(T t);
    T update(String id, T t);
    T getById(String id);
    boolean delete(String id);
}
