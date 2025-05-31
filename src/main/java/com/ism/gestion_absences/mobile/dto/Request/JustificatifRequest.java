package com.ism.gestion_absences.mobile.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "JustificatifRequest", description = "Ceci est le DTO qui represente les champs saisie pour la creation d'un justificatif")
public class JustificatifRequest {
    private String motif;
    private String presenceId;
}
