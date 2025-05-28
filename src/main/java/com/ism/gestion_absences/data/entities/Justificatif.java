package com.ism.gestion_absences.data.entities;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "justificatifs")
public class Justificatif extends AbstractEntity {
    private String motif;
    private boolean validation;
    private Presence presence;
    
}
