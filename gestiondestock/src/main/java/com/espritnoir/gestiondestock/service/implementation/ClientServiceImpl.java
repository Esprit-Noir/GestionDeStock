package com.espritnoir.gestiondestock.service.implementation;

import com.espritnoir.gestiondestock.dto.ClientDto;
import com.espritnoir.gestiondestock.exception.EntityNotFoundException;
import com.espritnoir.gestiondestock.exception.ErrorCodes;
import com.espritnoir.gestiondestock.exception.InvalidEntityException;
import com.espritnoir.gestiondestock.model.Client;
import com.espritnoir.gestiondestock.repository.ClientRepository;
import com.espritnoir.gestiondestock.service.ClientService;
import com.espritnoir.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id==null){
            log.error("Client id is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun client avec l'ID = "+ id +" n'est été trouvé dans la base de données",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
                );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Client id is null");
            return;
        }
        clientRepository.deleteById(id);
    }
}
