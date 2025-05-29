package com.ism.gestion_absences.utils.mappers;

import org.mapstruct.Mapper;

import com.ism.gestion_absences.data.entities.Admin;
import com.ism.gestion_absences.data.entities.Vigile;
import com.ism.gestion_absences.web.dto.Response.UserOneResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserOneResponse toUserOneResponse(Admin admin);
    UserOneResponse toUserOneResponse(Vigile user);
    
}
