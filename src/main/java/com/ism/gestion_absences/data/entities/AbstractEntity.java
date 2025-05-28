package com.ism.gestion_absences.data.entities;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractEntity {
    @Id
    private String id;
}
