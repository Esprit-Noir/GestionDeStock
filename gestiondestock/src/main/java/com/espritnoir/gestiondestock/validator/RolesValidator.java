package com.espritnoir.gestiondestock.validator;

import com.espritnoir.gestiondestock.dto.CategoryDto;
import com.espritnoir.gestiondestock.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public static List<String> validate(RolesDto rolesDto){
        List<String> errors = new ArrayList<>();
        if (rolesDto == null){
            errors.add("Veuillez renseigner le nom du role de l'utilisateur");
            return errors;
        }

        if (!StringUtils.hasLength(rolesDto.getNom())){
            errors.add("Veuillez renseigner le nom du role de l'utilisateur");
        }
        return errors;
    }
}
