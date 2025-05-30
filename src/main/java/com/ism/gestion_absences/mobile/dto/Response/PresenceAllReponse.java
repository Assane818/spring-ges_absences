package com.ism.gestion_absences.mobile.dto.Response;

import java.time.LocalDateTime;

import com.ism.gestion_absences.data.enums.TypePresence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenceAllReponse {
    private LocalDateTime date;
    private TypePresence typePresence;
}
