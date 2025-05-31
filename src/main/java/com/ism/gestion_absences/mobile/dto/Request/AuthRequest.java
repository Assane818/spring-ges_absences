package com.ism.gestion_absences.mobile.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "AuthRequest", description = "Ceci est le DTO qui represente les champs saisie lors de la connexion")
public class AuthRequest {
    private String login;
    private String password;
}
