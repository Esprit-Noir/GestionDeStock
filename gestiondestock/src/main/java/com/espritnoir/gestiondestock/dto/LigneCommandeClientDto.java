package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.LigneCommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {
    private Integer id;

    private ArticleDto article;

    private CommandeClientDto commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if (ligneCommandeClient == null){
            return null;
            // TODO throw an exception
        }
        // Mapping LigneCommandeClient -> LigneCommandeClientDto
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if (ligneCommandeClientDto == null ){
            return null;
            // TODO throw an exception
        }
        // Mapping LigneCommandeClientDto -> LigneCommandeClient
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
        ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()));

        return ligneCommandeClient;
    }
}
