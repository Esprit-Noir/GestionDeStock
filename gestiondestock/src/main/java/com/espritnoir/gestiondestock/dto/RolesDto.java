package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.Roles;
import com.espritnoir.gestiondestock.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
public class RolesDto {
    private Integer id;

    private String nom;

    private UtilisateurDto utilisateur;

    public static RolesDto fromEntity(Roles roles){
        if (roles == null){
            return null;
            // TODO throw an exception
        }
        // Mapping Roles -> RolesDto
        return RolesDto.builder()
                .id(roles.getId())
                .nom(roles.getNom())
                .utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
                .build();
    }
    public static Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return null;
            // TODO throw an exception
        }
        // Mapping RolesDto -> Roles
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setNom(rolesDto.getNom());
        roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateur()));
        return roles;

    }
}
