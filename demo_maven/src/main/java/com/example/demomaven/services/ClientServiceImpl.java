package com.example.demomaven.services;

import com.example.demomaven.dtos.ClientDTO;
import com.example.demomaven.entities.Client;
import com.example.demomaven.mappers.ClientMapper;
import com.example.demomaven.repos.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        System.out.println(clientDTO);
        Client client = clientMapper.toClient(clientDTO);
        client.setId(UUID.randomUUID().toString());
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOs = clients.stream().map(client -> clientMapper.toDto(client)).collect(Collectors.toList());
        return clientDTOs;
    }
}
