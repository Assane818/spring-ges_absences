package com.ism.gestion_absences.web.dto.Response;

import java.time.LocalDate;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PresenseAllWebResponse", description = "Ceci est un DTO qui represente la reponse de la liste des presences de tous les etudiants")
public class PresenseAllWebResponse {
    private String id;
    private LocalDate date;
    private String typePresence;
    private String matricule;
    private String nom;
    private String prenom;
    private String nomCours;
}
