package com.ism.gestion_absences.data.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends AbstractEntity {
    private String nom;
    private String prenom;
    private String login;
    private String telephone;
    private String password;
}
