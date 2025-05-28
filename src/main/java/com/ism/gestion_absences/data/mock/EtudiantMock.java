package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Classe;
import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.data.repository.ClasseRepository;
import com.ism.gestion_absences.data.repository.EtudiantRepository;

import lombok.RequiredArgsConstructor;

// @Component
// @Order(2)
@RequiredArgsConstructor
public class EtudiantMock implements CommandLineRunner {
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Etudiant> etudiants = new ArrayList<>();
        var classes = classeRepository.findAll();
        for (Classe classe : classes) {
            for (int i = 0; i < 5; i++) {
                Etudiant etudiant = new Etudiant();
                etudiant.setNom("Etudiant " + i);
                etudiant.setPrenom("Prenom " + i);
                etudiant.setLogin("etudiant" + i + "@gmail.com");
                etudiant.setPassword("passer");
                etudiant.setTelephone("77100101"+i);
                etudiant.setMatricule("MAT" + i);
                etudiant.setStatus(i % 2 == 0);
                etudiant.setClasse(classe);
                etudiants.add(etudiant);
            }
        }
        etudiantRepository.saveAll(etudiants);
    }

}
