package com.espritnoir.gestiondestock.service.implementation;

import com.espritnoir.gestiondestock.dto.ArticleDto;
import com.espritnoir.gestiondestock.dto.RolesDto;
import com.espritnoir.gestiondestock.exception.EntityNotFoundException;
import com.espritnoir.gestiondestock.exception.ErrorCodes;
import com.espritnoir.gestiondestock.exception.InvalidEntityException;
import com.espritnoir.gestiondestock.model.Article;
import com.espritnoir.gestiondestock.model.Roles;
import com.espritnoir.gestiondestock.repository.RolesRepository;
import com.espritnoir.gestiondestock.service.RolesService;
import com.espritnoir.gestiondestock.validator.ArticleValidator;
import com.espritnoir.gestiondestock.validator.RolesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RolesServiceImpl implements RolesService {
    private RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public RolesDto save(RolesDto dto) {
        List<String> errors = RolesValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Role is not valid {}", dto);
            throw new InvalidEntityException("Le role n'est pas valide", ErrorCodes.ROLES_NOT_VALID, errors);
        }
        return RolesDto.fromEntity(rolesRepository.save(RolesDto.toEntity(dto)));
    }

    @Override
    public RolesDto findById(Integer id) {
        if (id==null){
            log.error("Role ID is null");
            return  null;
        }
        Optional<Roles> roles = rolesRepository.findById(id);
        return Optional.of(RolesDto.fromEntity(roles.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun role avec l'ID = "+ id +" n'est été trouvé dans la base de données",
                        ErrorCodes.ROLES_NOT_FOUND
                )
        );
    }

    @Override
    public List<RolesDto> findAll() {
        return rolesRepository.findAll().stream()
                .map(RolesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Role ID is null");
            return;
        }
        rolesRepository.deleteById(id);
    }
}
