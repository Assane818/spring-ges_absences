package com.ism.gestion_absences.data.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "admins")
public class Admin extends User {
    private List<Presence> absences;
}
