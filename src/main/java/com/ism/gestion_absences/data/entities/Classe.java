package com.ism.gestion_absences.data.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "classes")
public class Classe extends AbstractEntity {
    private String filiere;
    private String niveau;
    private String nomClasse;
    private List<Etudiant> etudiants;
}
