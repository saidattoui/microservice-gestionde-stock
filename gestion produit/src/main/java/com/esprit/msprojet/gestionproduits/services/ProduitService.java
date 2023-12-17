package com.esprit.msprojet.gestionproduits.services;

import com.esprit.msprojet.gestionproduits.entities.Categorie;
import com.esprit.msprojet.gestionproduits.entities.Produit;
import com.esprit.msprojet.gestionproduits.repositories.CategorieRepository;
import com.esprit.msprojet.gestionproduits.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    public void addProduit(Produit produit) {
        produitRepository.save(produit);
    }

    public void deleteProduitById(Long idProduit) {
        produitRepository.deleteById(idProduit);
    }

    public Produit getProduitById(Long idProduit) {
        return produitRepository.findById(idProduit)
                .orElseThrow(() -> new IllegalStateException("Produit avec id " + idProduit + " n'existe pas"));
    }
    public void updateProduit(Long idProduit, Produit produit) {
        Produit produitToUpdate = getProduitById(idProduit);
        if (produitToUpdate != null){
            if (produit != null && !Objects.equals(produitToUpdate, produit)){
                produitToUpdate.setCodeBarre(produit.getCodeBarre());
                produitToUpdate.setDescription(produit.getDescription());
                produitToUpdate.setDateExpiration(produit.getDateExpiration());
                produitToUpdate.setPrixUnitaire(produit.getPrixUnitaire());
                produitToUpdate.setCategorie(produit.getCategorie());
                produitRepository.save(produit);
            }
        }
        else throw new IllegalStateException("Produit avec id " + idProduit + " n'existe pas");

    }
    public void assignCategorieToProduit(Long idProduit, Long idCategorie) {

        Categorie categorie = categorieRepository.findById(idProduit).orElse(null);
        Produit produit = produitRepository.findById(idCategorie).orElse(null);
        categorie.setProduits((List<Produit>) produit);
        categorieRepository.save(categorie);

    }

    public List<Produit> retrieveAllProduitByCodeBarre(String codeBarre) {
        return produitRepository.retrieveAllProduitByCodeBarre(codeBarre);
    }
    public List<Produit> retrieveAllProduitByPixUnitaireDesc() {
        return produitRepository.retrieveAllProduitByPixUnitaireDesc();
    }
    public List<Produit> retrieveAllProduitsByPrixUnitaireAsc() {
        return produitRepository.retrieveAllProduitsByPrixUnitaireAsc();
    }

}
