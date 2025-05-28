package com.ism.gestion_absences.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ism.gestion_absences.data.entities.Admin;

@RequestMapping("/api/v1/admins")
public interface AdminController extends Controller<Admin> {

}
