package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Justificatif;

@RequestMapping("/api/v1/justificatifs")
public interface JustificatifController extends Controller<Justificatif> {

}
