package com.ism.gestion_absences.mobile.dto.Response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "JustificatifOneResponse", description = "Ceci est un DTO qui represente la reponse simple d'un justificatif d'absence")
public class JustificatifOneResponse {
    private String id;
    private String motif;
    private boolean validation;
    private String presenceId;
    private String nom;
    private String prenom;
    private List<String> files;

}
