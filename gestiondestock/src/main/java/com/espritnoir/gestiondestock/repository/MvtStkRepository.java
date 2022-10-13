package com.espritnoir.gestiondestock.repository;

import com.espritnoir.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<Integer, LigneVente> {
}
