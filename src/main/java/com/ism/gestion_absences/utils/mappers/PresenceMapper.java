package com.ism.gestion_absences.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.mobile.dto.Response.PresenceAllResponse;
import com.ism.gestion_absences.mobile.dto.Response.PresenceOneResponse;
import com.ism.gestion_absences.web.dto.Response.PresenceOneWebResponse;
import com.ism.gestion_absences.web.dto.Response.PresenseAllWebResponse;

@Mapper(componentModel = "spring")
public interface PresenceMapper {
    @Mapping(source = "cours.nomCours", target = "cours")
    PresenceAllResponse toPresenceAllReponse(Presence presence);
    @Mapping(source = "cours.nomCours", target = "cours")
    @Mapping(source = "cours.heureDebut", target = "heureDebut")
    @Mapping(source = "cours.heureFin", target = "heureFin")
    PresenceOneResponse toPresenceOneResponse(Presence presence);

    @Mapping(source = "cours.nomCours", target = "nomCours")
    @Mapping(source = "etudiant.matricule", target = "matricule")
    @Mapping(source = "etudiant.nom", target = "nom")
    @Mapping(source = "etudiant.prenom", target = "prenom")
    PresenseAllWebResponse toPresenseAllWebResponse(Presence presence);

    @Mapping(source = "cours.nomCours", target = "cours")
    @Mapping(source = "cours.heureDebut", target = "heureDebut")
    @Mapping(source = "cours.heureFin", target = "heureFin")
    PresenceOneWebResponse toPresenceOneWebResponse(Presence presence);
}