package com.ism.gestion_absences.web.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOneResponse {
    private String id;
    private String nom;
    private String prenom;
    private String login;
    private String telephone;
    private String role;
}

//role en string 