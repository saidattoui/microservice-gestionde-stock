package com.esprit.microservices.candidate.controller;

import com.esprit.microservices.candidate.Repositories.HistoriqueRepository;
import com.esprit.microservices.candidate.entities.Historique;
import com.esprit.microservices.candidate.services.IHistoriqueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/historique")
public class HistoriqueController {
    HistoriqueRepository historiqueRepository;
    IHistoriqueService iHistoriqueService;
    @GetMapping("/retrieve-all-historiques")
    public List<Historique> getHistoriques() {
        List<Historique> listHistoriques = iHistoriqueService.retrieveAllHistoriques();
        return listHistoriques;}

    @GetMapping("/retrieve-historique/{historique-id}")
    public Historique retrieveEtudiant(@PathVariable("etudiant-id") Long historiqueId) {
        return iHistoriqueService.retrieveHistorique(historiqueId);
    }

    @DeleteMapping("/remove-historique/{historique-id}")
    public void removeHistorique(@PathVariable("historique-id") Long historiqueId) {
        iHistoriqueService.removeHistorique(historiqueId);
    }
    @PutMapping("/update-historique")
    public Historique updateEtudiant(@RequestBody Historique u) {
        Historique historique= iHistoriqueService.updateHistorique(u);
        return historique;
    }
    @PostMapping("/add-historique")
    public  Historique addHistorique(@RequestBody  Historique u) {
        Historique historique = iHistoriqueService.addHistorique(u);
        return  historique;
    }
}
