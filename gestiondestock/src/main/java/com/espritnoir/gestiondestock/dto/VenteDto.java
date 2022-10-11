package com.espritnoir.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class VenteDto {
    private Integer id;

    private String Code;

    private Instant dateVente;

    private String commentaire;
}
