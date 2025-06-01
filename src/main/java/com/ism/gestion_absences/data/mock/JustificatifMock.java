package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Justificatif;
import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.data.repository.JustificatifRepository;
import com.ism.gestion_absences.data.repository.PresenceRepository;

import lombok.RequiredArgsConstructor;

// @Component
// @Order(3)
@RequiredArgsConstructor
public class JustificatifMock implements CommandLineRunner {
    private final JustificatifRepository justificatifRepository;
    private final PresenceRepository presenceRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Justificatif> justificatifs = new ArrayList<>();
        List<Presence> presences = presenceRepository.findAll();
        for (Presence presence : presences) {
            if (presence.getTypePresence() == TypePresence.ABSENT) {
                var justificatif = new Justificatif();
                justificatif.setMotif("Motif de l'absence");
                justificatif.setValidation(false);
                justificatif.setPresence(presence);
                justificatifs.add(justificatif);
            }
        }
        justificatifRepository.saveAll(justificatifs);
    }

}
