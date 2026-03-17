package com.joakim.freelancertoolkitbackend.controller;

import com.joakim.freelancertoolkitbackend.domain.Client;
import com.joakim.freelancertoolkitbackend.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;


    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }
}
