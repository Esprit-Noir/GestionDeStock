package com.espritnoir.gestiondestock.service;

import com.espritnoir.gestiondestock.dto.RolesDto;

import java.util.List;

public interface RolesService {
    RolesDto save(RolesDto dto);
    RolesDto findById(Integer id);
    List<RolesDto> findAll();
    void delete(Integer id);
}
