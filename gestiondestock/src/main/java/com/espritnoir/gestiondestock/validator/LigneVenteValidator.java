package com.espritnoir.gestiondestock.validator;

import com.espritnoir.gestiondestock.dto.LigneVenteDto;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {
    public static List<String> validate(LigneVenteDto ligneVenteDto){
        List<String> errors = new ArrayList<>();
        if (ligneVenteDto == null){
            errors.add("La vente ne doit pas etre null");
            errors.add("L'article ne doit pas etre null");
            errors.add("La quantite ne doit pas etre null");
            errors.add("Le prix unitaire ne doit pas etre null");
            return errors;
        }

        if (ligneVenteDto.getVente() == null){
            errors.add("La vente ne doit pas etre null");
        }
        if (ligneVenteDto.getArticle() == null){
            errors.add("L'article ne doit pas etre null");
        }
        if (ligneVenteDto.getQuantite() == null){
            errors.add("La quantite ne doit pas etre null");
        }
        if (ligneVenteDto.getPrixUnitaire() == null){
            errors.add("Le prix unitaire ne doit pas etre null");
        }
        return errors;
    }
}
