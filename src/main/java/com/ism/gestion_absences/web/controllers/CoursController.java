package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Cours;

@RequestMapping("/api/v1/cours")
public interface CoursController extends Controller<Cours> {

}
