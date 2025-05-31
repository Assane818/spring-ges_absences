package com.ism.gestion_absences.mobile.dto.Response;

import java.time.LocalDate;

import com.ism.gestion_absences.data.enums.TypePresence;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PresenceAllResponse", description = "Ceci est le DTO qui represente la reponse de la liste des presences de tous les etudiants")
public class PresenceAllResponse {
    private LocalDate date;
    private String cours;
    private TypePresence typePresence;
}
