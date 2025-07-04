package com.ism.gestion_absences.mobile.controllers;

import java.time.LocalDate;
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


@RequestMapping("/api/v1/cours")
public interface CoursController extends Controller<Cours> {
    @GetMapping("/etudiant/{id}")
    @Operation(summary = "Recupere les cours de l'etudiant par date", description = "Retourne les cours de l'etudiant par date")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "les cours par date de l'etudiant sont retournes avec succes"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la recuperation des cours du jour de l'etudiant connecter"
        )
    })
    ResponseEntity<Map<String,Object>> getCoursByEtudiant(@PathVariable String id, @RequestParam(required = false)LocalDate date);
}
