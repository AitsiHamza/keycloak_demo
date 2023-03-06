package com.example.demomaven.services;

import com.example.demomaven.dtos.ClientDTO;
import com.example.demomaven.entities.Client;
import com.example.demomaven.mappers.ClientMapper;
import com.example.demomaven.repos.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ClientMapper clientMapper;

    private ClientService clientService;

    @BeforeEach
    void setUp()
    {
        this.clientService=new ClientServiceImpl(this.clientRepository,this.clientMapper);
    }

    @Test
    public void getAllTest(){
        List<ClientDTO> all1 = clientService.getAll();
        System.out.println(all1);
        List<Client> all = verify(clientRepository).findAll();
        System.out.println(all);
    }
}
