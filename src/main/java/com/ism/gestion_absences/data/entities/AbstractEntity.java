package com.ism.gestion_absences.data.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {
    @Id
    private String id;
}
