package com.ism.gestion_absences.utils.mappers;

import org.mapstruct.Mapper;

import com.ism.gestion_absences.data.entities.Cours;
import com.ism.gestion_absences.mobile.dto.Response.CoursAllResponse;
import com.ism.gestion_absences.web.dto.Response.CoursAllWebResponse;

@Mapper(componentModel = "spring")
public interface CoursMapper {
    CoursAllResponse toCoursAllResponse(Cours cours);
    CoursAllWebResponse toCoursAllWebResponse(Cours cours);
}
