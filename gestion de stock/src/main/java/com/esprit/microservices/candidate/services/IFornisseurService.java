package com.esprit.microservices.candidate.services;

import com.esprit.microservices.candidate.entities.Fournisseur;

import java.util.List;

public interface IFornisseurService {


    List<Fournisseur> retrieveAllFournisseurs();
    Fournisseur addFournisseur (Fournisseur u);
    Fournisseur updateFournisseur (Fournisseur u);
      Fournisseur retrieveFournisseur(long idFournisseur);
       void removeFournisseur  (long idFournisseur );

    List<Fournisseur> rechercheParNom(String nom);
}

