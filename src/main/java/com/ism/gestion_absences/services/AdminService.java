package com.ism.gestion_absences.services;

import java.util.List;

import com.ism.gestion_absences.data.entities.Admin;
import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.data.entities.Justificatif;
import com.ism.gestion_absences.data.enums.TypePresence;

public interface AdminService extends Service<Admin> {
    Justificatif validateJustificatif(String justificatifId, boolean isValid);
    List<Cours> getPresencesByCours(TypePresence typePresence, String coursId);
    List<Cours> getPresencesByDate(TypePresence typePresence, String coursId);
    
}
