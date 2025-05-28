package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Classe;
import com.ism.gestion_absences.data.repository.ClasseRepository;

import lombok.RequiredArgsConstructor;

@Component
@Order(1)
@RequiredArgsConstructor
public class ClasseMock implements CommandLineRunner {
    public final ClasseRepository classeRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Classe> classes = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Classe classe = new Classe();
            classe.setFiliere("Filiere " + i);
            classe.setNiveau("Niveau " + i);
            classes.add(classe);
        }
        classeRepository.saveAll(classes);
    }

}
