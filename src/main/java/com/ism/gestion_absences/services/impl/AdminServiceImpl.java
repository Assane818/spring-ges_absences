package com.ism.gestion_absences.services.impl;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.ism.gestion_absences.data.entities.Admin;
import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.data.entities.Justificatif;
import com.ism.gestion_absences.data.enums.TypePresence;
import com.ism.gestion_absences.services.AdminService;

public class AdminServiceImpl implements AdminService {

    @Override
    public Page<Admin> getAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    @Override
    public List<Admin> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Admin create(Admin t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Admin update(Long id, Admin t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Admin getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean delete(Long id) {
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
