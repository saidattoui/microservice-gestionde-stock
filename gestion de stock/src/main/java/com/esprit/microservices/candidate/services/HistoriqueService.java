package com.esprit.microservices.candidate.services;

import com.esprit.microservices.candidate.Repositories.HistoriqueRepository;
import com.esprit.microservices.candidate.entities.Historique;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class HistoriqueService  implements  IHistoriqueService{
    HistoriqueRepository historiqueRepository;
    @Override
    public List<Historique> retrieveAllHistoriques() {
        return historiqueRepository.findAll();
    }



    @Override
    public Historique addHistorique(Historique u) {
        return historiqueRepository.save(u);
    }

    @Override
    public Historique updateHistorique(Historique u) {
        return historiqueRepository.save(u);
    }

    @Override
    public Historique retrieveHistorique(long idHistorique) {
        return historiqueRepository.findById(idHistorique ).get();
    }

    @Override
    public void removeHistorique(long idHistorique) {
        historiqueRepository.deleteById(idHistorique );

    }
}
