package com.example.demomaven.mappers;

import com.example.demomaven.dtos.ClientDTO;
import com.example.demomaven.entities.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ClientMapper {
    Client toClient(ClientDTO clientDTO);
    ClientDTO toDto(Client client);
}
