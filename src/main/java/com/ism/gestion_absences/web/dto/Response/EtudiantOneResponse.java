package com.ism.gestion_absences.web.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "EtudiantOneResponse", description = "Ceci est un DTO qui represente la reponse simple d'un etudiant")
public class EtudiantOneResponse {
    private String id;
    private String nom;
    private String prenom;
    private String matricule;
    private String classe;
    private boolean status;
}
