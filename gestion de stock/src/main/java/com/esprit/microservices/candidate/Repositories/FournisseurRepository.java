package com.esprit.microservices.candidate.Repositories;

import com.esprit.microservices.candidate.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> findByNomContainingIgnoreCase(String nom);
}
