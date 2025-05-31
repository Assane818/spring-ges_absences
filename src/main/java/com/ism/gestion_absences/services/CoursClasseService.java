package com.ism.gestion_absences.services;

import java.util.List;

import com.ism.gestion_absences.data.entities.CoursClasse;

public interface CoursClasseService extends Service<CoursClasse> {
    List<CoursClasse> getByClasseId(String classeId);
}
