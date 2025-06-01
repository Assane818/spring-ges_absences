package com.ism.gestion_absences.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ism.gestion_absences.data.entities.Etudiant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RequestMapping("/api/web/v1/etudiants")
public interface EtudiantWebController extends WebController<Etudiant> {
    @GetMapping("/classe/{classeId}")
    @Operation(summary = "Recupere les etudiants d'une classe", description = "Retourne la liste des etudiants d'une classe a partir de son id")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "la liste des etudiants de la classe est retourne"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "la classe n'existe pas ou ne contient pas d'etudiants"
        )
    })
    ResponseEntity<Map<String,Object>> getByClasseId(@PathVariable String classeId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    );

    @GetMapping("/status/{status}")
    @Operation(summary = "Recupere les etudiants par status", description = "Retourne la liste des etudiants par rapport a leur status")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "la liste des etudiants par status est retourne"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "la classe n'existe pas ou ne contient pas d'etudiants"
        )
    })
    ResponseEntity<Map<String,Object>> getByStatus(@PathVariable String status,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    );
}
