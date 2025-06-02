package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Classe;

@RequestMapping("api/web/v1/classes")
public interface ClasseWebController extends WebController<Classe> {

}
