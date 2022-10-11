package com.espritnoir.gestiondestock.dto;


import com.espritnoir.gestiondestock.model.Adresse;
import com.espritnoir.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private Integer id;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;

    private List<CommandeClientDto> commandeClients;
}
