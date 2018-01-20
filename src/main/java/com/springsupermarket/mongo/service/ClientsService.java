package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Client;

import java.util.List;

public interface ClientsService {
    Client findById(Integer id);
    void save(Client client);
    void update(Client client);
    void delete(Integer id);

    List<Client> getAll();
    List<Client> getBy(Client client);
}
