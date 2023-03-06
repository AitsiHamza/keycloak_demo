package com.example.demomaven.services;

import com.example.demomaven.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> getAll();
}
