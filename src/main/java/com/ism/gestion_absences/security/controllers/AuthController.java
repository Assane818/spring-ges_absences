package com.ism.gestion_absences.security.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.mobile.dto.Request.AuthRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api/v1/auth")
public interface AuthController {
    @PostMapping("/login")
    @Operation(summary = "Se connecter", description = "Retourne l'utilisateur connecté")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "l'utilisateur est connecté avec succès"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la connexion de l'utilisateur"
        )
    })
    ResponseEntity<Map<String,Object>> login(AuthRequest authRequest);
}
