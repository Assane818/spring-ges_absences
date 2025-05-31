package com.ism.gestion_absences.data.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "cours_classes")
public class CoursClasse extends AbstractEntity {
    private String id;
    private Cours cours;
    private Classe classe;
}
