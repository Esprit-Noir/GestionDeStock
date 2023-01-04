package com.espritnoir.gestiondestock.controller.api;

import com.espritnoir.gestiondestock.dto.VenteDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.espritnoir.gestiondestock.utils.Constants.APP_ROOT;

public interface VenteApi {
    @PostMapping(value = APP_ROOT + "/vente/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto save(VenteDto dto);
    @GetMapping(value = APP_ROOT + "/vente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findById(Integer id);
    @GetMapping(value = APP_ROOT + "/vente/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VenteDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/vente/delete/{id}")
    void delete(Integer id);
}
