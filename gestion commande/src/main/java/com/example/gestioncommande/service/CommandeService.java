package com.example.gestioncommande.service;

import com.example.gestioncommande.entity.Commande;
import com.example.gestioncommande.entity.StatCommande;
import com.example.gestioncommande.entity.StatutCommande;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommandeService {
    public Commande addCommande(Commande commande);
    public Commande updateCommande(Commande commande);

    void deleteCommande(Long id);

    public List<Commande> listCommande();
    public Commande getOneById(Long id);
    public List<StatCommande> getStat();

    public List<Commande> getOneByStaCommande(StatutCommande statutCommande);

}
