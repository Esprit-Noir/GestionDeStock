package com.espritnoir.gestiondestock.service.implementation;

import com.espritnoir.gestiondestock.dto.ArticleDto;
import com.espritnoir.gestiondestock.dto.VenteDto;
import com.espritnoir.gestiondestock.exception.EntityNotFoundException;
import com.espritnoir.gestiondestock.exception.ErrorCodes;
import com.espritnoir.gestiondestock.exception.InvalidEntityException;
import com.espritnoir.gestiondestock.model.Article;
import com.espritnoir.gestiondestock.model.Vente;
import com.espritnoir.gestiondestock.repository.VenteRepository;
import com.espritnoir.gestiondestock.service.VenteService;
import com.espritnoir.gestiondestock.validator.ArticleValidator;
import com.espritnoir.gestiondestock.validator.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {
    private VenteRepository venteRepository;

    @Autowired
    public VenteServiceImpl(VenteRepository venteRepository) {
        this.venteRepository = venteRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VenteValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Vente is not valid {}", dto);
            throw new InvalidEntityException("La vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }
        return VenteDto.fromEntity(venteRepository.save(VenteDto.toEntity(dto)));
    }

    @Override
    public VenteDto findById(Integer id) {
        if (id==null){
            log.error("Vente ID is null");
            return  null;
        }
        Optional<Vente> vente = venteRepository.findById(id);
        return Optional.of(VenteDto.fromEntity(vente.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun vente avec l'ID = "+ id +" n'est été trouvé dans la base de données",
                        ErrorCodes.VENTE_NOT_FOUND
                )
        );
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Vente ID is null");
            return ;
        }
        venteRepository.deleteById(id);
    }
}
