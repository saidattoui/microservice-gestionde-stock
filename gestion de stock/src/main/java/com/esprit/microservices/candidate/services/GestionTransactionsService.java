package com.esprit.microservices.candidate.services;


import com.esprit.microservices.candidate.Repositories.FournisseurRepository;
import com.esprit.microservices.candidate.Repositories.HistoriqueRepository;
import com.esprit.microservices.candidate.entities.Fournisseur;
import com.esprit.microservices.candidate.entities.Historique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GestionTransactionsService {
    private final FournisseurRepository fournisseurRepository;
    private final HistoriqueRepository historiqueRepository;

    @Autowired
    public GestionTransactionsService(FournisseurRepository fournisseurRepository, HistoriqueRepository historiqueRepository) {
        this.fournisseurRepository = fournisseurRepository;
        this.historiqueRepository = historiqueRepository;
    }

    public void enregistrerTransaction(Long fournisseurId, Long nouveauPrix) {
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);

        if (fournisseur != null) {
            Historique historique = new Historique();
            historique.setFournisseur(fournisseur);
            historique.setDate(new Date());
            historique.setPrix(nouveauPrix);

            historiqueRepository.save(historique);
        }
    }

    public List<Historique> obtenirHistoriquesAchats(Long fournisseurId) {
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);

        if (fournisseur != null) {
            return fournisseur.getHistoriques();
        }

        return null;
    }
}