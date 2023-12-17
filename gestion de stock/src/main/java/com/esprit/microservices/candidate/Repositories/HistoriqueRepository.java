package com.esprit.microservices.candidate.Repositories;


import com.esprit.microservices.candidate.entities.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
}
