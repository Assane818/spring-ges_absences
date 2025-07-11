package com.ism.gestion_absences.data.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "cours")
public class Cours extends AbstractEntity {
    private LocalDate date;
    private String nomCours;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private List<Presence> absences;
}
