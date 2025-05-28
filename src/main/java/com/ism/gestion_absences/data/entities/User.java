package com.ism.gestion_absences.data.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User extends AbstractEntity {
    private String nom;
    private String prenom;
    private String login;
    private String telephone;
    private String password;
}
