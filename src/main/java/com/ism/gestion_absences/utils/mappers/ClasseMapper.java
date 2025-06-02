package com.ism.gestion_absences.utils.mappers;

import org.mapstruct.Mapper;

import com.ism.gestion_absences.data.entities.Classe;
import com.ism.gestion_absences.web.dto.Response.ClasseAllWebResponse;

@Mapper(componentModel = "spring")
public interface ClasseMapper {
    ClasseAllWebResponse toClasseAllWebResponse(Classe classe);
}
