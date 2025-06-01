package com.ism.gestion_absences.web.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "JustificatifOneWebResponse", description = "Ceci est un DTO qui represente la liste des justificatifs d'absence pour le web")
public class JustificatifOneWebResponse {
    private String motif;
    private boolean validation;
    private String presenceId;
    private String nomEtudiant;
    private String prenomEtudiant;
    private String matricule;
    private String classe;
}
