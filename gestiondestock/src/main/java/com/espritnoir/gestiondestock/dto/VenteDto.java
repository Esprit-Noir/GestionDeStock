package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.Vente;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class VenteDto {
    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    public static VenteDto fromEntity(Vente vente){
        if (vente == null){
            return null;
            // TODO throw an exception
        }
        // Mapping Vente -> VenteDto
        return  VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .build();
    }
    public static Vente toEntity(VenteDto venteDto){
        if (venteDto == null){
            return null;
            // TODO throw an exception
        }
        // Mapping VenteDto -> Vente
        Vente vente =new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}
