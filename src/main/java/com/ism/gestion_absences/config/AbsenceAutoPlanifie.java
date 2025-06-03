package com.ism.gestion_absences.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.CoursClasse;
import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.services.CoursClasseService;
import com.ism.gestion_absences.services.EtudiantService;
import com.ism.gestion_absences.services.PresenceService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AbsenceAutoPlanifie {

    private final EtudiantService etudiantService;
    private final PresenceService presenceService;
    private final CoursClasseService coursClasseService;

    @Scheduled(cron = "0 0 20 * * ?")
    public void planifierAbsences() {
        List<Etudiant> Alletudiants = etudiantService.getAll();
        LocalDate dateNow = LocalDate.now();
        for (Etudiant etudiant : Alletudiants) {
            List<CoursClasse> coursClassesList = coursClasseService.getByClasseId(etudiant.getClasse().getId());
            if (!coursClassesList.isEmpty()) {
                for (CoursClasse coursClasse : coursClassesList) {
                    if (coursClasse.getCours().getDate().equals(dateNow)) {
                        Presence presence = presenceService.getByEtudiantIdAndCoursId(etudiant.getId(), coursClasse.getCours().getId());
                        if (presence == null) {
                            presence = new Presence();
                            presence.setEtudiant(etudiant);
                            presence.setCours(coursClasse.getCours());
                            presence.setDate(dateNow);
                            presence.setTypePresence(TypePresence.ABSENT);
                            presenceService.create(presence);
                        } 
                    }
                } 
            }
        }
    }
}
