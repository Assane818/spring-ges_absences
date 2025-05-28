package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Classe;

@RequestMapping("/api/v1/classes")
public interface ClasseControler extends Controller<Classe> {

}
