package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Classe;
import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.data.entities.CoursClasse;
import com.ism.gestion_absences.data.repository.ClasseRepository;
import com.ism.gestion_absences.data.repository.CoursClasseRepository;
import com.ism.gestion_absences.data.repository.CoursRepository;

import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class CoursClasseMock implements CommandLineRunner {

    private final CoursRepository coursRepository;
    private final ClasseRepository classeRepository;
    private final CoursClasseRepository coursClasseRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Cours> coursList = coursRepository.findAll();
        List<Classe> classes = classeRepository.findAll();
        List<CoursClasse>  coursClasses = new ArrayList<>();
        for (Classe classe : classes) {
            for (Cours cours : coursList) {
                CoursClasse coursClasse = new CoursClasse();
                coursClasse.setCours(cours);
                coursClasse.setClasse(classe);
                coursClasses.add(coursClasse);
            }
        }
        coursClasseRepository.saveAll(coursClasses);
    }

}
