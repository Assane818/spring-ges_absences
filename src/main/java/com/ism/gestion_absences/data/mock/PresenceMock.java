package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Admin;
import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.data.entities.CoursClasse;
import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.data.repository.AdminRepository;
import com.ism.gestion_absences.data.repository.CoursClasseRepository;
import com.ism.gestion_absences.data.repository.EtudiantRepository;
import com.ism.gestion_absences.data.repository.PresenceRepository;

import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class PresenceMock implements CommandLineRunner  {
    private final PresenceRepository presenceRepository;
    private final EtudiantRepository etudiantRepository;
    private final CoursClasseRepository coursClasseRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Presence> presences = new ArrayList<>();
        List<CoursClasse> coursClasseList = coursClasseRepository.findAll();
        for (CoursClasse coursClasse : coursClasseList) {
            List<Etudiant> etudiants = etudiantRepository.findByClasseId(coursClasse.getClasse().getId());
            for (Etudiant etudiant : etudiants) {
                Cours cours = coursClasse.getCours();
                Presence presence = new Presence();
                presence.setDate(cours.getDate());
                presence.setTypePresence(Math.random() < 0.5 ? TypePresence.PRESENT : TypePresence.ABSENT);
                presence.setEtudiant(etudiant);
                presence.setCours(cours);
                presences.add(presence);
            }
        }
        presenceRepository.saveAll(presences);
    }

}