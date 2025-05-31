package com.ism.gestion_absences.mobile.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.mobile.dto.Request.JustificatifRequest;

@RequestMapping("/api/v1/justificatifs")
public interface JustificatifController extends Controller<JustificatifRequest> {

}
