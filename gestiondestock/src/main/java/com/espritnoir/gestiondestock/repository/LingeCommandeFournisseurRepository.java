package com.espritnoir.gestiondestock.repository;

import com.espritnoir.gestiondestock.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LingeCommandeFournisseurRepository extends JpaRepository<Integer, LigneCommandeFournisseur> {
}
