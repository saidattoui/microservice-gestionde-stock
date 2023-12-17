package com.esprit.msprojet.gestionproduits.repositories;

import com.esprit.msprojet.gestionproduits.entities.Categorie;
import com.esprit.msprojet.gestionproduits.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @Query("select p from Produit p where p.codeBarre LIKE %:codeBarre% ")
    List<Produit> retrieveAllProduitByCodeBarre(@Param("codeBarre") String codeBarre);
    @Query("select p from Produit p order by p.prixUnitaire asc")
    List<Produit> retrieveAllProduitsByPrixUnitaireAsc();
    @Query("select p from Produit p order by p.prixUnitaire desc")
    List<Produit> retrieveAllProduitByPixUnitaireDesc();
}
