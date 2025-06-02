package com.ism.gestion_absences.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ism.gestion_absences.data.entities.Justificatif;

public interface JustificatifService extends Service<Justificatif> {
    Justificatif create(Justificatif justificatif, List<MultipartFile> files) throws IOException;
}
