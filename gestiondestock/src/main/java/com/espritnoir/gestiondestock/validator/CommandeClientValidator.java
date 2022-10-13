package com.espritnoir.gestiondestock.validator;

import com.espritnoir.gestiondestock.dto.CategoryDto;
import com.espritnoir.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();
        if (commandeClientDto == null){
            errors.add("Veuillez renseigner le code de la commande du client");
            errors.add("Veuillez renseigner la date de la commande du client");
            errors.add("Veuillez selectionner un client pour la commande");
        }

        if (!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("Veuillez renseigner le code de la commande du client");
        }
        if (commandeClientDto.getDateCommande() == null){
            errors.add("Veuillez renseigner la date de la commande du client");
        }
        if (commandeClientDto.getClient() == null){
            errors.add("Veuillez selectionner un client pour la commande");
        }
        return errors;
    }
}
