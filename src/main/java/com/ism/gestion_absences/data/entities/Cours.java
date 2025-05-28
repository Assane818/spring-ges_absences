package com.ism.gestion_absences.data.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "cours")
public class Cours extends AbstractEntity {
    private String nomCours;
    private int duree;
    private List<Presence> absences;
}
