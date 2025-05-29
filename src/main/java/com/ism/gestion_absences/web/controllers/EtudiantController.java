package com.ism.gestion_absences.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Etudiant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RequestMapping("/api/v1/etudiants")
public interface EtudiantController extends Controller<Etudiant> {
    @GetMapping("/matricule/{matricule}")
    @Operation(summary = "Recupere un etudiant a travers sa matricule", description = "Retourne un etudiant a partir de sa matricule fournie")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "l'etudiant est retournees"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "l'etudiant n'existe pas"
        )
    })
    ResponseEntity<Map<String, Object>> getByMatricule(@PathVariable String matricule);
}
