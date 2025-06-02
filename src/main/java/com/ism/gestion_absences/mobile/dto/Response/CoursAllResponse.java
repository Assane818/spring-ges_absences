package com.ism.gestion_absences.mobile.dto.Response;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "CoursAllResponse", description = "Ceci est le DTO qui represente la reponse de la liste des cours pour l'application mobile")
public class CoursAllResponse {
    private String id;
    private LocalDate date;
    private String nomCours;
    private LocalTime heureDebut;
    private LocalTime heureFin;
}
//AbsenseAllResponse

