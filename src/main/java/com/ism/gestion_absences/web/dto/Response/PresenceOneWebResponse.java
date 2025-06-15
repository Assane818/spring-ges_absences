
package com.ism.gestion_absences.web.dto.Response;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ism.gestion_absences.data.enums.TypePresence;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PresenceOneWebResponse", description = "Ceci est le DTO qui represente la reponse de la presenece d'un etudiant format web")
public class PresenceOneWebResponse {
    private String id;
    private LocalDate date;
    private String nom;
    private String prenom;
    private String matricule;
    private String cours;
    private TypePresence typePresence;
    private LocalTime heureDebut;
    private LocalTime heureFin;
}
