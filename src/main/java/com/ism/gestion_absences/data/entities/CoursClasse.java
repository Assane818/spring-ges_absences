package com.ism.gestion_absences.data.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursClasse extends AbstractEntity {
    private Cours cours;
    private Classe classe;
}
