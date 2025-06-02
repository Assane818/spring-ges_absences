package com.ism.gestion_absences.web.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "EtudiantAllWebResponse", description = "Ceci est un DTO qui represente la liste des etudiants")
public class EtudiantAllWebResponse {
    private String id;
    private String nom;
    private String prenom;
    private String matricule;
    private String classe;
    private String filiere;
    private boolean status;
    private String role;
}
