package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Presence;

@RequestMapping("/api/v1/presences")
public interface PresenceController extends Controller<Presence> {
    
}
