package com.company.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.company.webservice.model.Client;
import com.company.webservice.repository.ClientRepository;
import com.company.webservice.wsdl.AddClientRequest;
import com.company.webservice.wsdl.ClientsResponse;
import com.company.webservice.wsdl.DeleteClientRequest;
import com.company.webservice.wsdl.EditClientRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl {

    private ClientRepository repository;

    public ClientsResponse findClients() {
        ClientsResponse response = new ClientsResponse();
        response.getClients().addAll(
                ((List<Client>) repository.findAll()).stream().map(
                    (client) -> {
                        com.company.webservice.wsdl.Client clientWs = new com.company.webservice.wsdl.Client();
                        clientWs.setClientId(client.getClientId());
                        clientWs.setName(client.getName());
                        return clientWs;
                    }
                ).collect(Collectors.toList())
        );

        return response;
    }

    public void addClient(AddClientRequest request) {
        repository.save(
            Client.builder()
                .name(request.getName())
            .build()
        );
    }

    public void editClient(EditClientRequest request) {
        com.company.webservice.wsdl.Client clientWs = request.getClient();
        repository.save(
                Client.builder()
                    .name(clientWs.getName())
                    .lastName(clientWs.getLastname())
                    .phone(clientWs.getPhone())
                .build()
        );
    }

    public void deleteClient(DeleteClientRequest request) {
    }

}
