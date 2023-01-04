package com.espritnoir.gestiondestock.controller.api;

import com.espritnoir.gestiondestock.dto.RolesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.espritnoir.gestiondestock.utils.Constants.APP_ROOT;

public interface RolesApi {
    @PostMapping(value = APP_ROOT + "/roles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto save(RolesDto dto);
    @GetMapping(value = APP_ROOT + "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto findById(Integer id);
    @GetMapping(value = APP_ROOT + "/roles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RolesDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/roles/delete/{id}")
    void delete(Integer id);
}
