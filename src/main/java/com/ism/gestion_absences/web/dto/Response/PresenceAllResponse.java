package com.ism.gestion_absences.web.dto.Response;

import java.time.LocalDateTime;

import com.ism.gestion_absences.data.enums.TypePresence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenceAllResponse {
    private LocalDateTime date;
    private TypePresence typePresence;
    private String cours;
}
