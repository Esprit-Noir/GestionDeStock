package com.espritnoir.gestiondestock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class Adresse {

    @Column(name = "adresse1")
    private String adresse1;

    @Column(name = "adresse2")
    private String adresse2;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codePostale ")
    private String codePostale;

    @Column(name = "pays")
    private String pays;

}
