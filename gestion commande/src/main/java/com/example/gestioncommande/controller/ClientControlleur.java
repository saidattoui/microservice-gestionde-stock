package com.example.gestioncommande.controller;

import com.example.gestioncommande.entity.Clients;
import com.example.gestioncommande.entity.Commande;
import com.example.gestioncommande.serviceImpl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Clients")
public class ClientControlleur {
    @Autowired
    private ClientServiceImpl ClientService;

    @PostMapping("/save")
    public Clients saveClient(@RequestBody Clients clients) {
        return ClientService.addClient(clients);
    }
    @PutMapping("/update")
    public Clients updClient(@RequestBody Clients clients){
         return ClientService.updateClient(clients);}
    @DeleteMapping("/delete/{clients-id}")
    public void  removeCommande(@PathVariable("clients-id") Long id) { ClientService. deleteClient(id);}
    @GetMapping("/findAll")
    public List<Clients> getAllClients(){
        return  ClientService.listClient();
    }
    @GetMapping("/findOne/{id}")
    public Clients getOne(@PathVariable Long id){
        return ClientService.getOneById(id);
    }



}