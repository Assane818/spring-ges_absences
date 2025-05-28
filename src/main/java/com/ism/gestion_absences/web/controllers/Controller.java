package com.ism.gestion_absences.web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface Controller<T> {
    @GetMapping("")
    @Operation(summary = "Recupere une liste d'objets", description = "Retourne une liste d'objets")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "la liste d'objets est retournees"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "la liste d'objets n'existe pas"
        )
    })
    ResponseEntity<Map<String,Object>> getAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    );
    @GetMapping("{id}")
    @Operation(summary = "Recupere un objet a travers son id", description = "Retourne l'objet")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "l'objet est retourne"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "l'objet n'existe pas"
        )
    })
    ResponseEntity<Map<String,Object>> getById(@PathVariable Long id);
    @PostMapping("")
    @Operation(summary = "cree un objet", description = "Retourne l'objet cree")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "l'objet cree avec succes"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la creation de l'objet"
        )
    })
    ResponseEntity<Map<String,Object>> create(T object, BindingResult bindingResult);
    @PutMapping("{id}")
    @Operation(summary = "Modifie un objet", description = "Retourne l'objet modifie")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "l'objet modifie avec succes"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la modification de l'objet"
        )
    })
    ResponseEntity<Map<String,Object>> update(@PathVariable Long id, T object, BindingResult bindingResult);
    @DeleteMapping("{id}")
    @Operation(summary = "Supprime un objet a travers son id", description = "Retourne true ou false")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "l'objet supprime avec succes"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "une erreur lors de la suppression de l'objet"
        )
    })
    ResponseEntity<Boolean> delete(@PathVariable Long id);
}
