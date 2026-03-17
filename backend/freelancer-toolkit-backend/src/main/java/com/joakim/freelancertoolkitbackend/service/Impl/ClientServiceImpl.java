package com.joakim.freelancertoolkitbackend.service.Impl;

import com.joakim.freelancertoolkitbackend.domain.Client;
import com.joakim.freelancertoolkitbackend.repository.ClientRepository;
import com.joakim.freelancertoolkitbackend.service.ClientService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
}
