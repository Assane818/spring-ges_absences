package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Vigile;
import com.ism.gestion_absences.data.repository.VigileRepository;

import lombok.RequiredArgsConstructor;

// @Component
// @Order
@RequiredArgsConstructor
public class VigileMock implements CommandLineRunner {
    private final VigileRepository vigileRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Vigile> vigiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Vigile vigile = new Vigile();
            vigile.setNom("Vigile " + i);
            vigile.setPrenom("Prenom " + i);
            vigile.setLogin("vigile" + i + "@gmail.com");
            vigile.setPassword("passer");
            vigile.setTelephone("77300301" + i);
            vigiles.add(vigile);
        }
        vigileRepository.saveAll(vigiles);
    }

}
