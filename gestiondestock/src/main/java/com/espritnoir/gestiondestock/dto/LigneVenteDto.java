package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.LigneVente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {
    private Integer id;

    private ArticleDto article;

    private VenteDto vente;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public  LigneVenteDto fromEntity(LigneVente ligneVente){
        if (ligneVente == null){
            return null;
            // TODO throw exception
        }
        // Mapping LigneVente -> LigneVenteDto
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .vente(VenteDto.fromEntity(ligneVente.getVente()))
                .build();
    }

    public LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if (ligneVenteDto == null){
            return null;
            // TODO throw an exception
        }
        // Mapping LigneVenteDto -> LigneVente
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
        ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));
        return ligneVente;
    }
}
