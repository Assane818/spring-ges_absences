package com.ism.gestion_absences.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ism.gestion_absences.data.entities.Justificatif;
import com.ism.gestion_absences.mobile.dto.Request.JustificatifRequest;
import com.ism.gestion_absences.mobile.dto.Response.JustificatifOneResponse;
import com.ism.gestion_absences.web.dto.Request.JustificatifUpdateRequest;
import com.ism.gestion_absences.web.dto.Response.JustificatifOneWebResponse;

@Mapper(componentModel = "spring")
public interface JustificatifMapper {
    Justificatif toEntity(JustificatifRequest justificatifRequest);
    @Mapping(source = "presence.id", target = "presenceId")
    @Mapping(source = "presence.etudiant.nom", target = "nomEtudiant")
    @Mapping(source = "presence.etudiant.prenom", target = "prenomEtudiant")
    JustificatifOneResponse toJustificatifOneResponse(Justificatif justificatif);

    @Mapping(source = "presence.id", target = "presenceId")
    @Mapping(source = "presence.etudiant.nom", target = "nomEtudiant")
    @Mapping(source = "presence.etudiant.prenom", target = "prenomEtudiant")
    @Mapping(source = "presence.etudiant.matricule", target = "matricule")
    @Mapping(source = "presence.etudiant.classe.nomClasse", target = "classe")
    JustificatifOneWebResponse toJustificatifOneWebResponse(Justificatif justificatif);
    Justificatif toEntity(JustificatifUpdateRequest justificatifUpdateRequest);
}