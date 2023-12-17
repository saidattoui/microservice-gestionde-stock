package com.example.gestioncommande.repository;

import com.example.gestioncommande.entity.Commande;
import com.example.gestioncommande.entity.StatutCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    public List<Commande> findByStatutCommande(StatutCommande statutCommande);
}
