package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Client;
import com.springsupermarket.mongo.repository.ClientsRepository;
import com.springsupermarket.mongo.repository.CountersRepository;
import com.springsupermarket.mongo.utils.MongoCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;
    @Autowired
    private CountersRepository countersRepository;

    @Override
    public Client findById(Integer id) {
        Client client = clientsRepository.findOne(id);
        return client;
    }

    @Override
    public void save(Client client) {
        Integer nextId = countersRepository.getNextId(MongoCollections.CLIENTS.getSequenceName());
        client.setId(nextId);
        clientsRepository.save(client);
    }

    @Override
    public void update(Client client) {
        Client cli = findById(client.getId());
        if (cli != null) {
            clientsRepository.save(client);
        }
    }

    @Override
    public void delete(Integer id) {
        clientsRepository.delete(id);
    }

    @Override
    public List<Client> getAll() {
        return clientsRepository.findAll();
    }

    @Override
    public List<Client> getBy(Client client) {
        return clientsRepository.findByAny(client);
    }
}
