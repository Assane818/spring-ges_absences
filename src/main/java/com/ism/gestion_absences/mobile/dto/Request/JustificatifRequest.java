package com.ism.gestion_absences.mobile.dto.Request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "JustificatifRequest", description = "Ceci est le DTO qui represente les champs saisie pour la creation d'un justificatif avec pieces jointes")
public class JustificatifRequest {
    private String motif;
    private String presenceId;
    private List<MultipartFile> multipartFiles;
}
