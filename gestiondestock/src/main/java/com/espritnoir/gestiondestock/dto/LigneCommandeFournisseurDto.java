package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.LigneCommandeFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private Integer id;

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if (ligneCommandeFournisseur == null){
            return null;
            // TDOD throw an exception
        }
        // Mapping LigneCommandeFournisseur -> LigneCommandeFournisseurDto
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if (ligneCommandeFournisseurDto == null){
            return null;
            // TODO throw an exception
        }
        // Mapping LigneCommandeFournisseurDto -> LigneCommandeFournisseur
        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.prixUnitaire);
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
        ligneCommandeFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseur()));
        return ligneCommandeFournisseur;
    }
}
