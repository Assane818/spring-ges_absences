package com.ism.gestion_absences.utils.mappers;

import org.mapstruct.Mapper;

import com.ism.gestion_absences.data.entities.Presence;
import com.ism.gestion_absences.web.dto.Response.PresenceAllReponse;

@Mapper(componentModel = "spring")
public interface PresenceMapper {
    PresenceAllReponse toPresenceAllReponse(Presence presence);
}
