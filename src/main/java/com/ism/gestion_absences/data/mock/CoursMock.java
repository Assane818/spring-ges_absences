package com.ism.gestion_absences.data.mock;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.data.repository.CoursRepository;

import lombok.RequiredArgsConstructor;
@Component
@Order(1)
@RequiredArgsConstructor
public class CoursMock implements CommandLineRunner {
    private final CoursRepository coursRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Cours> coursList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Cours cours = new Cours();
            cours.setNomCours("Cours " + i);
            cours.setDate(LocalDateTime.now().plusDays(i));
            cours.setHeureDebut(LocalTime.now().plusHours(i));
            cours.setHeureFin(LocalTime.now().plusHours(4));
            coursList.add(cours);
        }
        coursRepository.saveAll(coursList);
    }

}
