package com.ism.gestion_absences.mobile.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RequestMapping("/api/v1/presences")
public interface PresenceController extends Controller<Presence> {
    @GetMapping("/type={type}")
    @Operation(summary = "Recupere une liste de presence a travers le type", description = "Retourne une liste de presences")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "la liste de presences est retourne"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Le lien n'est pas valide"
        )
    })
    ResponseEntity<Map<String,Object>> getByType(
        @PathVariable String type,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    );

    @GetMapping("/type={type}/etudiant/{etudiantId}")
    @Operation(summary = "Recupere une liste de presence a travers l'id d'un etudiant", description = "Retourne une liste de presences")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "la liste de presences est retourne"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Le lien n'est pas valide"
        )
    })
    ResponseEntity<Map<String,Object>> getByEtudiantId(
        @PathVariable String etudiantId, @PathVariable TypePresence type);

    @GetMapping("/etudiant/{matricule}")
    @Operation(summary = "Recupere l'etudiant scanne", description = "Retourne la presence cree pour l'etudiant scanne")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "la presence est creee avec succes pour l'etudiant scanne"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la creation de la presence pour l'etudiant scanne"
        )
    })
    ResponseEntity<Map<String,Object>> pointage(@PathVariable String matricule);
}
