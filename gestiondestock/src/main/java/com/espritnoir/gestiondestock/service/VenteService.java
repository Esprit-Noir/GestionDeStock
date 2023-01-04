package com.espritnoir.gestiondestock.service;

import com.espritnoir.gestiondestock.dto.VenteDto;

import java.util.List;

public interface VenteService {
    VenteDto save(VenteDto dto);
    VenteDto findById(Integer id);
    List<VenteDto> findAll();
    void delete(Integer id);
}
