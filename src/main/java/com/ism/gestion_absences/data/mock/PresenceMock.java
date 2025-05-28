package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.data.repository.CoursRepository;
import com.ism.gestion_absences.data.repository.EtudiantRepository;
import com.ism.gestion_absences.data.repository.PresenceRepository;

import lombok.RequiredArgsConstructor;

// @Component
// @Order(2)
@RequiredArgsConstructor
public class PresenceMock implements CommandLineRunner  {
    private final PresenceRepository presenceRepository;
    private final EtudiantRepository etudiantRepository;
    private final CoursRepository coursRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Presence> presences = new ArrayList<>();
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<Cours> coursList = coursRepository.findAll();
        for (Cours cours : coursList) {
            for (int i = 0; i < 10; i++) {
                Presence presence = new Presence();
                presence.setTypePresence(i % 2 == 0 ? TypePresence.PRESENT : TypePresence.ABSENT);
                presence.setEtudiant(etudiants.get(i));
                presence.setCours(cours);
                presences.add(presence);
            }
        }
        presenceRepository.saveAll(presences);
    }

}
