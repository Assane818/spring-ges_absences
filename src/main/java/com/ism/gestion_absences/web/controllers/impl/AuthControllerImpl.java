package com.ism.gestion_absences.web.controllers.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ism.gestion_absences.data.entities.Admin;
import com.ism.gestion_absences.data.entities.Vigile;
import com.ism.gestion_absences.data.repository.AdminRepository;
import com.ism.gestion_absences.data.repository.EtudiantRepository;
import com.ism.gestion_absences.data.repository.VigileRepository;
import com.ism.gestion_absences.utils.mappers.EtudiantMapper;
import com.ism.gestion_absences.utils.mappers.UserMapper;
import com.ism.gestion_absences.web.controllers.AuthController;
import com.ism.gestion_absences.web.dto.Request.AuthRequest;
import com.ism.gestion_absences.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AdminRepository adminRepository;
    private final VigileRepository vigileRepository;
    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<Map<String, Object>> login(@RequestBody AuthRequest authRequest) {
        Optional<Admin> admin = adminRepository.findFirstByLogin(authRequest.getLogin());
        if (admin.isPresent() && passwordEncoder.matches(authRequest.getPassword(), admin.get().getPassword())) {
            return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, userMapper.toUserOneResponse(admin.get()), "UserOneResponse"), HttpStatus.OK);
        }
        Optional<Vigile> vigile = vigileRepository.findByLogin(authRequest.getLogin());
        if (vigile.isPresent() && passwordEncoder.matches(authRequest.getPassword(), vigile.get().getPassword())) {
            return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, userMapper.toUserOneResponse(vigile.get()), "UserOneResponse"), HttpStatus.OK);
        }
        var etudiant = etudiantRepository.findFirstByLogin(authRequest.getLogin());
        if (etudiant.isPresent() && passwordEncoder.matches(authRequest.getPassword(), etudiant.get().getPassword())) {
            return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, etudiantMapper.toEtudiantOneResponse(etudiant.get()), "EtudiantOneResponse"), HttpStatus.OK);
        }
        return new ResponseEntity<>(RestResponse.response(HttpStatus.UNAUTHORIZED, null, "Unauthorized"), HttpStatus.UNAUTHORIZED);
    }
}
