package com.ism.gestion_absences.security.controllers.impl;

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
import com.ism.gestion_absences.mobile.dto.Request.AuthRequest;
import com.ism.gestion_absences.security.controllers.AuthController;
import com.ism.gestion_absences.security.jwt.JwtService;
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
    private final JwtService jwtService;
    @Override
    public ResponseEntity<Map<String, Object>> login(@RequestBody AuthRequest authRequest) {
        Optional<Admin> admin = adminRepository.findFirstByLogin(authRequest.getLogin());
        if (admin.isPresent() && passwordEncoder.matches(authRequest.getPassword(), admin.get().getPassword())) {
            String token = jwtService.generateToken(admin.get().getLogin(), admin.get().getRole().name());
            return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, Map.of(
                "token", token,
                "user", userMapper.toUserOneResponse(admin.get())
            ), "AuthResponse"), HttpStatus.OK);
        }
        Optional<Vigile> vigile = vigileRepository.findByLogin(authRequest.getLogin());
        if (vigile.isPresent() && passwordEncoder.matches(authRequest.getPassword(), vigile.get().getPassword())) {
            String token = jwtService.generateToken(vigile.get().getLogin(), vigile.get().getRole().name());
            return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, Map.of(
                "token", token,
                "user", userMapper.toUserOneResponse(vigile.get())
            ), "AuthResponse"), HttpStatus.OK);
        }
        var etudiant = etudiantRepository.findFirstByLogin(authRequest.getLogin());
        if (etudiant.isPresent() && passwordEncoder.matches(authRequest.getPassword(), etudiant.get().getPassword())) {
            String token = jwtService.generateToken(etudiant.get().getLogin(), etudiant.get().getRole().name());
            return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, Map.of(
                "token", token,
                "user", etudiantMapper.toEtudiantOneResponse(etudiant.get())
            ), "AuthResponse"), HttpStatus.OK);
        }
        return new ResponseEntity<>(RestResponse.response(HttpStatus.UNAUTHORIZED, null, "Unauthorized"), HttpStatus.UNAUTHORIZED);
    }
}
