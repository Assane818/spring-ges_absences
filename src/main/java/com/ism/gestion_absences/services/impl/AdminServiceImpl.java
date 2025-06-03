package com.ism.gestion_absences.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ism.gestion_absences.data.entities.Admin;
import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.data.entities.Justificatif;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.data.repository.AdminRepository;
import com.ism.gestion_absences.services.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    @Override
    public Page<Admin> getAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin create(Admin t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Admin update(String id, Admin t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Admin getById(String id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Justificatif validateJustificatif(String justificatifId, boolean isValid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateJustificatif'");
    }

    @Override
    public List<Cours> getPresencesByCours(TypePresence typePresence, String coursId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPresencesByCours'");
    }

    @Override
    public List<Cours> getPresencesByDate(TypePresence typePresence, String coursId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPresencesByDate'");
    }
    
    
}
