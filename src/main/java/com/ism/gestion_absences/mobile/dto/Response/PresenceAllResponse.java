package com.ism.gestion_absences.mobile.dto.Response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PresenceAllResponse", description = "Ceci est le DTO qui represente la reponse de la liste des presences de tous les etudiants")
public class PresenceAllResponse {
    private String id;
    private String nom;
    private String prenom;
    private String matricule;
    private String classe;
    private String nomCours;
    private LocalDateTime date;
}
