package com.esprit.msprojet.gestionproduits.repositories;

import com.esprit.msprojet.gestionproduits.entities.Categorie;
import com.esprit.msprojet.gestionproduits.entities.TypeCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    @Query("select c from Categorie c where c.nom = ?1")
    List<Categorie> findCategorieByNom(String nom);

    List<Categorie> findByType(TypeCategorie type);
    @Query("SELECT DISTINCT c FROM Categorie c JOIN c.produits p WHERE p.dateExpiration >= CURRENT_DATE AND p.dateExpiration <= :expirationDate")
    List<Categorie> findCategoriesWithProductsExpiringSoon(@Param("expirationDate") LocalDate expirationDate);

}

