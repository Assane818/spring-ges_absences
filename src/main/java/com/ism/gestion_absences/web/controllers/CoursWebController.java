package com.ism.gestion_absences.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ism.gestion_absences.data.entities.Cours;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api/web/v1/justificatifs")
public interface CoursWebController extends WebController<Cours> {
    @GetMapping("/date/{date}")
    @Operation(summary = "Recupere les cours d'une date", description = "Retourne les cours d'une date")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "les cours de la date donnee sont retournes avec succes"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la recuperation des cours"
        )
    })
    ResponseEntity<Map<String,Object>> getCoursByDate(@PathVariable String date,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    );

}
