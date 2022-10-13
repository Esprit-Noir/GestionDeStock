package com.espritnoir.gestiondestock.repository;

import com.espritnoir.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Integer, Client> {
}
