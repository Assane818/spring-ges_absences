package com.ism.gestion_absences.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.gestion_absences.data.entities.Admin;
import com.ism.gestion_absences.data.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

// @Component
// @Order(1)
@RequiredArgsConstructor
public class AdminMock implements CommandLineRunner {
    private final AdminRepository adminRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Admin> admins = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Admin admin = new Admin();
            admin.setNom("Admin " + i);
            admin.setPrenom("Prenom " + i);
            admin.setLogin("admin" + i + "@gmail.com");
            admin.setPassword("passer");
            admin.setTelephone("77200201" + i);
            admins.add(admin);
        }
        adminRepository.saveAll(admins);
    }

}
