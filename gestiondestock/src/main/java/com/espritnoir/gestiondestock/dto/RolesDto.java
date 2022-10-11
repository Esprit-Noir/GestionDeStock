package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.Utilisateur;
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
}
