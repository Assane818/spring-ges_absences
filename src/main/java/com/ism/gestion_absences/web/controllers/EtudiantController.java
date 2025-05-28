package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Etudiant;

@RequestMapping("/api/v1/etudiants")
public interface EtudiantController extends Controller<Etudiant> {

}
