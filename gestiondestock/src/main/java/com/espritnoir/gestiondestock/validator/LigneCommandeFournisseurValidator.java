package com.espritnoir.gestiondestock.validator;

import com.espritnoir.gestiondestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        List<String> errors = new ArrayList<>();
        if (ligneCommandeFournisseurDto == null){
            errors.add("L'Article ne doit pas etre null");
            errors.add("La commande client ne doit pas etre null");
            errors.add("La quantite ne doit pas etre null");
            errors.add("Le prix unitaire ne doit pas etre null");
            return errors;
        }

        if (ligneCommandeFournisseurDto.getArticle() == null){
            errors.add("L'Article ne doit pas etre null");
        }
        if (ligneCommandeFournisseurDto.getCommandeFournisseur() == null){
            errors.add("La commande client ne doit pas etre null");
        }
        if (ligneCommandeFournisseurDto.getQuantite() == null){
            errors.add("La quantite ne doit pas etre null");
        }
        if (ligneCommandeFournisseurDto.getPrixUnitaire() == null){
            errors.add("Le prix unitaire ne doit pas etre null");
        }
        return errors;
    }
}
