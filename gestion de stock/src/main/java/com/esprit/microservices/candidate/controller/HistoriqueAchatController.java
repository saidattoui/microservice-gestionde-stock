package com.esprit.microservices.candidate.controller;

import com.esprit.microservices.candidate.entities.Historique;
import com.esprit.microservices.candidate.services.GestionTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historique-achats")
public class HistoriqueAchatController {

    private final GestionTransactionsService gestionTransactionsService;

    @Autowired
    public HistoriqueAchatController(GestionTransactionsService gestionTransactionsService) {
        this.gestionTransactionsService = gestionTransactionsService;
    }

    @PostMapping("/enregistrer-transaction/{fournisseurId}")
    public void enregistrerTransaction(@PathVariable Long fournisseurId, @RequestParam Long nouveauPrix) {
        gestionTransactionsService.enregistrerTransaction(fournisseurId, nouveauPrix);
    }

    @GetMapping("/obtenir-historiques/{fournisseurId}")
    public List<Historique> obtenirHistoriquesAchats(@PathVariable Long fournisseurId) {
        return gestionTransactionsService.obtenirHistoriquesAchats(fournisseurId);
    }
}

