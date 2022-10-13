package com.espritnoir.gestiondestock.repository;

import com.espritnoir.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, Category> {
}
