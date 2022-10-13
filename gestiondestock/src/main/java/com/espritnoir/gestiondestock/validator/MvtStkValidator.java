package com.espritnoir.gestiondestock.validator;

import com.espritnoir.gestiondestock.dto.CategoryDto;
import com.espritnoir.gestiondestock.dto.MvtStkDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {
    public static List<String> validate(MvtStkDto mvtStkDto){
        List<String> errors = new ArrayList<>();
        if (mvtStkDto == null){
            errors.add("Veuillez renseigner la date du mouvement du stocke");
            errors.add("Veuillez renseigner la quantite du mouvement du stocke");
            errors.add("Veuillez renseigner le type du mouvement du stocke");
            errors.add("Veuillez selectionner les ou l'article du mouvement du stocke");
            return errors;
        }

        if (mvtStkDto.getDateMvt() == null){
            errors.add("Veuillez renseigner la date du mouvement du stocke");
        }
        if (mvtStkDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantite du mouvement du stocke");
        }
        if (mvtStkDto.getTypeMvtStk() == null){
            errors.add("Veuillez renseigner le type du mouvement du stocke");
        }
        if (mvtStkDto.getArticle() == null){
            errors.add("Veuillez selectionner les ou l'article du mouvement du stocke");
        }
        return errors;
    }
}
