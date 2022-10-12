package com.espritnoir.gestiondestock.dto;


import com.espritnoir.gestiondestock.model.CommandeFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CommandeFournisseurDto {
    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur == null){
            return null;
            //TODO throw an exception
        }
        // Mapping commandeFournisseur -> commandeFournisseurDto
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .ligneCommandeFournisseurs(
                        commandeFournisseur.getLigneCommandeFournisseurs() != null ?
                                commandeFournisseur.getLigneCommandeFournisseurs().stream()
                                        .map(LigneCommandeFournisseurDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }
    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if (commandeFournisseurDto == null){
            return null;
            // TODO throw an exception
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
        commandeFournisseur.setLigneCommandeFournisseurs(
                commandeFournisseurDto.getLigneCommandeFournisseurs() != null ?
                        commandeFournisseurDto.getLigneCommandeFournisseurs().stream()
                                .map(LigneCommandeFournisseurDto::toEntity)
                                .collect(Collectors.toList()) : null
        );
        return commandeFournisseur;
    }
}
