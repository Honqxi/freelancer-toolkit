package com.joakim.freelancertoolkitbackend.service;

import com.joakim.freelancertoolkitbackend.domain.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    Client createClient(Client client);
}
