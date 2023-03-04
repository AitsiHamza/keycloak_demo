package com.example.demo.mappers;

import com.example.demo.dtos.ClientDTO;
import com.example.demo.entities.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ClientMapper {
    Client toClient(ClientDTO clientDTO);
    ClientDTO toDto(Client client);
}
