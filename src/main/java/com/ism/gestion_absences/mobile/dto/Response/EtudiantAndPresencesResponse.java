package com.ism.gestion_absences.mobile.dto.Response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "EtudiantAndPresencesResponse", description = "Ceci est le DTO qui represente la reponse d'un etudiant avec ses presences")
public class EtudiantAndPresencesResponse {
    private EtudiantOneResponse etudiant;
    private List<PresenceAllResponse> presences;
    
    public EtudiantAndPresencesResponse(EtudiantOneResponse etudiant, List<PresenceAllResponse> presences) {
        this.etudiant = etudiant;
        this.presences = presences;
    }
}
