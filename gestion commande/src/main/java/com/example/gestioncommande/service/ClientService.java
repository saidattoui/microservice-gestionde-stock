package com.example.gestioncommande.service;

import com.example.gestioncommande.entity.Clients;
import com.example.gestioncommande.entity.Commande;

import java.util.List;

public interface ClientService
{
    public Clients addClient  (Clients clients);
    public Clients updateClient (Clients clients);
     void  deleteClient (Long id);
    public List<Clients> listClient();
    public Clients getOneById(Long id);
}
