package com.espritnoir.gestiondestock.dto;


import com.espritnoir.gestiondestock.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;

    private String nom;

    private String prenom;

    private String dateDeNaissance;

    private String motDePasse;

    private AdresseDto adresse;

    private String photo;

    private String email;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
            // TODO throw an exception
        }
        // Mapping Utilisateur -> UtilisateurDto
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .motDePasse(utilisateur.getMotDePasse())
                .photo(utilisateur.getPhoto())
                .email(utilisateur.getEmail())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .roles(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return null;
            // TODO throw an exception
        }
        // Mapping UtilisateurDto -> Utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
        utilisateur.setRoles(
                utilisateurDto.getRoles() != null ?
                        utilisateurDto.getRoles().stream()
                                .map(RolesDto::toEntity)
                                .collect(Collectors.toList()) : null
        );
        return utilisateur;
    }
}
