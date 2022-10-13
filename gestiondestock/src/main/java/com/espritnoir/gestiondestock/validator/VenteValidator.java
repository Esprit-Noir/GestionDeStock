package com.espritnoir.gestiondestock.validator;

import com.espritnoir.gestiondestock.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {
    public static List<String> validate(VenteDto venteDto){
        List<String> errors = new ArrayList<>();
        if (venteDto == null){
            errors.add("Veuillez renseigner le code de la vente");
            errors.add("Veuillez renseigner le commentaire de la vente");
            errors.add("Veuillez renseigner la date de la vente est obligatoir");
            return errors;
        }
        if (!StringUtils.hasLength(venteDto.getCode())){
            errors.add("Veuillez renseigner le code de la vente");
        }
        if (!StringUtils.hasLength(venteDto.getCommentaire())){
            errors.add("Veuillez renseigner le commentaire de la vente");
        }
        if (venteDto.getCode() == null){
            errors.add("Veuillez renseigner la date de la vente est obligatoir");
        }

        return errors;
    }
}
