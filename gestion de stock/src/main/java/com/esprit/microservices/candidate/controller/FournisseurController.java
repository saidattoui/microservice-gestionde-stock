package com.esprit.microservices.candidate.controller;

import com.esprit.microservices.candidate.Repositories.FournisseurRepository;
import com.esprit.microservices.candidate.entities.Fournisseur;
import com.esprit.microservices.candidate.services.IFornisseurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/fournisseur")
public class FournisseurController {
    FournisseurRepository fournisseurRepository;
    IFornisseurService iFornisseurService;
    @GetMapping("/retrieve-all-fournisseurs")
    public List<Fournisseur> getFournisseurs() {
        List<Fournisseur> listFournisseurs = iFornisseurService.retrieveAllFournisseurs();
        return listFournisseurs;}

    @GetMapping("/retrieve-fournisseur/{fournisseur-id}")
    public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return  iFornisseurService.retrieveFournisseur(fournisseurId);
    }

    @DeleteMapping("/remove-fournisseur/{fournisseur-id}")
    public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        iFornisseurService.removeFournisseur(fournisseurId);
    }
    @PutMapping("/update-fournisseur")
    public  Fournisseur updateFournisseur(@RequestBody  Fournisseur u) {
        Fournisseur fournisseur= iFornisseurService.updateFournisseur(u);
        return fournisseur;
    }
    @PostMapping("/add-fournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur u) {
        Fournisseur fournisseur = iFornisseurService.addFournisseur(u);
        return fournisseur;
    }
    @GetMapping("/recherche-candidat")
    public List< Fournisseur> rechercheCandidatParNom(@RequestParam String nom) {
        return iFornisseurService.rechercheParNom(nom);
    }
}
