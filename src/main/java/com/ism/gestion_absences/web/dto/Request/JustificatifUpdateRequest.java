package com.ism.gestion_absences.web.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JustificatifUpdateRequest {
    private boolean validation;
    private String adminId;
}
