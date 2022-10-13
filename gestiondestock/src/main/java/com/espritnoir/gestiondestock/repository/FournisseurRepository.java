package com.espritnoir.gestiondestock.repository;

import com.espritnoir.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Integer, Fournisseur> {
}
