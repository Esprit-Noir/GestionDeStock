package com.espritnoir.gestiondestock.validator;

import com.espritnoir.gestiondestock.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
        List<String> errors = new ArrayList<>();
        if (ligneCommandeClientDto == null){
            errors.add("L'Article ne doit pas etre null");
            errors.add("La commande client ne doit pas etre null");
            errors.add("La quantite ne doit pas etre null");
            errors.add("Le prix unitaire ne doit pas etre null");
            return errors;
        }

        if (ligneCommandeClientDto.getArticle() == null){
            errors.add("L'Article ne doit pas etre null");
        }
        if (ligneCommandeClientDto.getCommandeClient() == null){
            errors.add("La commande client ne doit pas etre null");
        }
        if (ligneCommandeClientDto.getQuantite() == null){
            errors.add("La quantite ne doit pas etre null");
        }
        if (ligneCommandeClientDto.getPrixUnitaire() == null){
            errors.add("Le prix unitaire ne doit pas etre null");
        }
        return errors;
    }
}
