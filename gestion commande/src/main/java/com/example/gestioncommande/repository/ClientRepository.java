package com.example.gestioncommande.repository;

import com.example.gestioncommande.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients,Long> {
}
