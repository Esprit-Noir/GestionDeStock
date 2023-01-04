package com.espritnoir.gestiondestock.controller.api;

import com.espritnoir.gestiondestock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.espritnoir.gestiondestock.utils.Constants.APP_ROOT;

public interface FournisseurApi {
    @PostMapping(value = APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(FournisseurDto dto);
    @GetMapping(value = APP_ROOT + "/fournisseur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(Integer id);
    @GetMapping(value = APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/fournisseur/delete/{id}")
    void delete(Integer id);
}
