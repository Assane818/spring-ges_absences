package com.ism.gestion_absences.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ism.gestion_absences.cloudinary.CloudinaryService;
import com.ism.gestion_absences.data.entities.Justificatif;
import com.ism.gestion_absences.data.repository.JustificatifRepository;
import com.ism.gestion_absences.services.JustificatifService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JustificatifServiceImpl implements JustificatifService {

    private final JustificatifRepository justificatifRepository;
    private final CloudinaryService cloudinaryService;
    @Override
    public Page<Justificatif> getAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPaginate'");
    }

    @Override
    public List<Justificatif> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Justificatif create(Justificatif t) {
        return justificatifRepository.save(t);
    }

    @Override
    public Justificatif update(String id, Justificatif t) {
        Justificatif just = justificatifRepository.findById(id).orElse(null);
        if (just != null) {
            just.setValidation(t.isValidation());
        }
        return justificatifRepository.save(just);
    }


    @Override
    public Justificatif getById(String id) {
        return justificatifRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Justificatif create(Justificatif justificatif, List<MultipartFile> files) throws IOException {
        List<String> uploadedUrls = new ArrayList<>();
        if (files != null) {
            for (MultipartFile file : files) {
                String url = cloudinaryService.uploadFile(file);
                uploadedUrls.add(url);
            }
        }
        justificatif.setFiles(uploadedUrls);
        return justificatifRepository.save(justificatif);
    }

    @Override
    public Justificatif getByPresenceId(String presenceId) {
        return justificatifRepository.findByPresenceId(presenceId);
    }

}
