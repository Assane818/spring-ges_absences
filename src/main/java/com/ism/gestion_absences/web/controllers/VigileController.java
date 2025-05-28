package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Vigile;

@RequestMapping("/api/v1/vigiles")
public interface VigileController extends Controller<Vigile> {

}
