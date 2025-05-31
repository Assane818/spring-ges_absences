package com.ism.gestion_absences.mobile.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "JustificatifOneResponse", description = "Ceci est un DTO qui represente la reponse simple d'un justificatif d'absence")
public class JustificatifOneResponse {
    private String motif;
    private boolean validation;
    private String presenceId;
    private String nomEtudiant;
    private String prenomEtudiant;
}
