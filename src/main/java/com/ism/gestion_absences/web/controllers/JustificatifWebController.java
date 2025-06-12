package com.ism.gestion_absences.web.controllers;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.web.dto.Request.JustificatifUpdateRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RequestMapping("/api/web/v1/justificatifs")
public interface JustificatifWebController extends WebController<JustificatifUpdateRequest> {
    
    @GetMapping("/presence/{presenceId}")
    @Operation(summary = "Recupere le justificatif d'une presence", description = "Retourne le justificatif d'une presence a partir de son id")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "le justificatif de la presence est retourne"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "la presence n'existe pas ou ne contient pas de justificatif"
        )
    })
    ResponseEntity<Map<String,Object>> getByPresenceId(@PathVariable String presenceId);
}
