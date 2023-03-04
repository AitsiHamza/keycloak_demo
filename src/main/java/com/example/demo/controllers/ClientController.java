package com.example.demo.controllers;

import com.example.demo.dtos.ClientDTO;
import com.example.demo.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAll(){
        return new ResponseEntity<>(clientService.getAll(),HttpStatus.ACCEPTED);
    }
    @PostMapping("/create")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.saveClient(clientDTO),HttpStatus.ACCEPTED);
    }
}
