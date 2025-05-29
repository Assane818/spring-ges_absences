package com.ism.gestion_absences.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ism.gestion_absences.data.entities.User;
import com.ism.gestion_absences.data.repository.AdminRepository;
import com.ism.gestion_absences.data.repository.EtudiantRepository;
import com.ism.gestion_absences.data.repository.VigileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final EtudiantRepository etudiantRepository;
    private final VigileRepository vigileRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<? extends User> userOpt = adminRepository.findFirstByLogin(login) .map(u -> (User) u)
                .or(() -> etudiantRepository.findFirstByLogin(login).map(u -> (User) u))
                .or(() -> vigileRepository.findByLogin(login).map(u -> (User) u));
        User user = userOpt.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
        return org.springframework.security.core.userdetails.User
            .withUsername(user.getLogin())
            .password(user.getPassword())
            .authorities("ROLE_" + user.getRole().name())
            .build();
    }

}
