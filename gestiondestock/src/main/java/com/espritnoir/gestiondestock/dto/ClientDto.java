package com.espritnoir.gestiondestock.dto;


import com.espritnoir.gestiondestock.model.Adresse;
import com.espritnoir.gestiondestock.model.Client;
import com.espritnoir.gestiondestock.model.CommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ClientDto {
    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client){
        if (client==null){
            return null;
            //TODO throw an exception
        }
        //Mapping Client -> ClientDto
        return  ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .commandeClients(
                        client.getCommandeClients() != null ?
                                client.getCommandeClients().stream()
                                        .map(CommandeClientDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if (clientDto == null){
            return null;
            //TODO throw an exception
        }
        //Mapping ClientDto -> Client
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setPhoto(client.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        client.setCommandeClients(
                clientDto.getCommandeClients() != null ?
                        clientDto.getCommandeClients().stream()
                                .map(CommandeClientDto::toEntity)
                                .collect(Collectors.toList()) : null
        );

        return client;
    }
}
