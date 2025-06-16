package com.ism.gestion_absences.mobile.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.mobile.dto.Request.JustificatifRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RequestMapping("/api/v1/justificatifs")
public interface JustificatifController extends Controller<JustificatifRequest> {
    @PostMapping("/create")
    @Operation(summary = "cree une justificatif", description = "Retourne la justificatif cree")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "la justificatif cree avec succes"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la creation de l'objet"
        )
    })
    ResponseEntity<Map<String,Object>> createJustificatif(JustificatifRequest object, BindingResult bindingResult) throws IOException;
}
