package com.ism.gestion_absences.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ism.gestion_absences.data.entities.Presence;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RequestMapping("/api/web/v1/presences")
public interface PresenceWebController extends WebController<Presence> {
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

    @GetMapping("/type={type}/cours/{coursId}")
    @Operation(summary = "Recupere une liste de presence a travers le type et l'id d'un cours", description = "Retourne une liste de presences")
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
    ResponseEntity<Map<String,Object>> getByCoursAndType(
        @PathVariable String type,
        @PathVariable String coursId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    );
}
