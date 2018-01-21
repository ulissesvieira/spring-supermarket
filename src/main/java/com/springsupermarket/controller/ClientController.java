package com.springsupermarket.controller;

import com.springsupermarket.entity.Client;
import com.springsupermarket.mongo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    @Autowired
    private ClientsService clientsService;

    @GetMapping("list")
    public List<Client> getAll() {
        return clientsService.getAll();
    }

    @PostMapping("save")
    public Client save(@RequestBody Client client) {
        clientsService.save(client);
        return client;
    }

    @GetMapping("findById/{id}")
    public Client findById(@PathVariable("id") Integer id) {
        Client client = clientsService.findById(id);
        return client;
    }

    @PutMapping("update")
    public Client update(@RequestBody Client client) {
        clientsService.update(client);
        return client;
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        clientsService.delete(id);
        return true;
    }
}
