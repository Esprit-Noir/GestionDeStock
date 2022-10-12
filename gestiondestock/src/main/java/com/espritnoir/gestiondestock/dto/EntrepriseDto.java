package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.Entreprise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class EntrepriseDto {
    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String siteWeb;

    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if (entreprise == null){
            return null;
            // TODO throw an excception
        }
        // Mapping Entreprise -> EntrepriseDto
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .utilisateurs(
                        entreprise.getUtilisateurs() != null ?
                                entreprise.getUtilisateurs().stream()
                                        .map(UtilisateurDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if (entrepriseDto == null){
            return null;
            // TODO throw an excception
        }
        // Mapping EntrepriseDto -> Entreprise
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        entreprise.setUtilisateurs(
                entrepriseDto.getUtilisateurs() != null ?
                        entrepriseDto.getUtilisateurs().stream()
                                .map(UtilisateurDto::toEntity)
                                .collect(Collectors.toList()) : null
        );
        return entreprise;
    }
}
