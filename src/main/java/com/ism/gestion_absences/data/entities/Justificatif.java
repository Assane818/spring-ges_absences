package com.ism.gestion_absences.data.entities;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
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
    List<String> files;
    
}
