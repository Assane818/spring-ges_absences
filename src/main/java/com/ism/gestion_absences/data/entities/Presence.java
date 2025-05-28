package com.ism.gestion_absences.data.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ism.gestion_absences.data.enums.TypePresence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "presences")
public class Presence extends AbstractEntity {
    private TypePresence typePreence;
    private List<Justificatif> justificatifs;
    private Etudiant etudiant;
    private Cours cours;
    private Admin admin;
}
