package com.esprit.microservices.candidate.services;

import com.esprit.microservices.candidate.entities.Fournisseur;
import com.esprit.microservices.candidate.entities.Historique;

import java.util.List;

public interface IHistoriqueService {
    List<Historique> retrieveAllHistoriques();
    Historique addHistorique (Historique u);
    Historique updateHistorique (Historique u);
    Historique retrieveHistorique (long idHistorique);
    void removeHistorique  (long idHistorique );
}
