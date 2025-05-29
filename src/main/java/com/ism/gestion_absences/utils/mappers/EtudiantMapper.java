package com.ism.gestion_absences.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ism.gestion_absences.data.entities.Etudiant;
import com.ism.gestion_absences.web.dto.Response.EtudiantOneResponse;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    @Mapping(source = "classe.nomClasse", target = "classe")
    EtudiantOneResponse toEtudiantOneResponse(Etudiant etudiant);
}
