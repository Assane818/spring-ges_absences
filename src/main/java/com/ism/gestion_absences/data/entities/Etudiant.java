package com.ism.gestion_absences.data.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "etudiants")
public class Etudiant extends User {
    private String matricule;
    private Classe classe;
    private boolean status;
    private List<Presence> absences;
}
