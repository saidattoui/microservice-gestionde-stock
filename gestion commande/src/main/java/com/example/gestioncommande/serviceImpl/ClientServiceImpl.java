package com.example.gestioncommande.serviceImpl;

import com.example.gestioncommande.entity.Clients;
import com.example.gestioncommande.entity.Commande;
import com.example.gestioncommande.repository.ClientRepository;
import com.example.gestioncommande.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Clients addClient(Clients clients) {
        return clientRepository.save(clients);
    }

    @Override
    public Clients updateClient(Clients clients) {
        return clientRepository.save(clients) ;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public List<Clients> listClient() {
        return clientRepository.findAll();
    }

    @Override
    public Clients getOneById(Long id) {
        return clientRepository.findById( id).get();
    }


}