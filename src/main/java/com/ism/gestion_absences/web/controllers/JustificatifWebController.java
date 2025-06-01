package com.ism.gestion_absences.web.controllers;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.web.dto.Request.JustificatifUpdateRequest;


@RequestMapping("/api/web/v1/justificatifs")
public interface JustificatifWebController extends WebController<JustificatifUpdateRequest> {
}
