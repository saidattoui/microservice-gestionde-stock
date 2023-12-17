package com.esprit.microservices.candidate.services;

import com.esprit.microservices.candidate.Repositories.FournisseurRepository;
import com.esprit.microservices.candidate.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FournisseurService implements  IFornisseurService{

FournisseurRepository fournisseurRepository;
    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        return fournisseurRepository.findAll();
    }



    @Override
    public Fournisseur addFournisseur(Fournisseur u) {
        return fournisseurRepository.save(u);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur u) {
        return fournisseurRepository.save(u);
    }

    @Override
    public Fournisseur retrieveFournisseur(long idFournisseur) {
        return fournisseurRepository.findById(idFournisseur).get();
    }

    @Override
    public void removeFournisseur(long idFournisseur) {
        fournisseurRepository.deleteById(idFournisseur);

    }

    public List<Fournisseur> rechercheParNom(String nom) {
        return fournisseurRepository.findByNomContainingIgnoreCase(nom);
    }

}
