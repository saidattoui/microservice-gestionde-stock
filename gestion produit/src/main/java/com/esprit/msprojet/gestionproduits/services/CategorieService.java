package com.esprit.msprojet.gestionproduits.services;

import com.esprit.msprojet.gestionproduits.entities.Categorie;
import com.esprit.msprojet.gestionproduits.entities.Produit;
import com.esprit.msprojet.gestionproduits.entities.TypeCategorie;
import com.esprit.msprojet.gestionproduits.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    public void addCategorie(Categorie categorie) {
        List<Categorie> existingCategories = categorieRepository.findCategorieByNom(categorie.getNom());
        if (!existingCategories.isEmpty()) {
            throw new IllegalStateException("Categorie " + categorie.getNom() + " already exists");
        }
        categorieRepository.save(categorie);
    }



    public void deleteCategorieById(Long idCategorie) {
        categorieRepository.deleteById(idCategorie);
    }

    public Categorie getCategorieById(Long idCategorie) {
        return categorieRepository.findById(idCategorie)
                .orElseThrow(() -> new IllegalStateException("Categorie  n'existe pas"));
    }

    public List<Categorie> getCategoriesByType(TypeCategorie type) {
        return categorieRepository.findByType(type);
    }
    public List<Categorie> getCategoriesWithProductsExpiringSoon(int daysThreshold) {
        try {
            LocalDate expirationDate = LocalDate.now().plusDays(daysThreshold);
            return categorieRepository.findCategoriesWithProductsExpiringSoon(expirationDate);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            throw new RuntimeException("An error occurred while fetching categories with expiring products.", e);
        }
    }


    public void updateCategorie(Long idCategorie, Categorie categorie) {
        Categorie CategorieToUpdate = getCategorieById(idCategorie);
        if (CategorieToUpdate != null) {
            if (categorie != null && !Objects.equals(CategorieToUpdate, categorie)) {
                CategorieToUpdate.setNom(categorie.getNom());
                CategorieToUpdate.setCodeCategorie(categorie.getCodeCategorie());
                CategorieToUpdate.setType(categorie.getType());
                categorieRepository.save(categorie);
            }
        } else throw new IllegalStateException("Categorie avec id " + idCategorie + " n'existe pas");

    }

    //****************************stat**********************************************
    public Map<String, Integer> categoriesStats() {
        int medicament = 0, dispositifMedical = 0, soinsPersonnels = 0, nutraceutiques = 0, alimentation = 0, equipementMedical = 0, diagnostic = 0;

        List<Categorie> allCategories = (List<Categorie>) categorieRepository.findAll();

        for (Categorie categorie : allCategories) {
            switch (categorie.getType()) {
                case MEDICAMENT:
                    medicament++;
                    break;
                case DISPOSITIF_MEDICAL:
                    dispositifMedical++;
                    break;
                case SOINS_PERSONNELS:
                    soinsPersonnels++;
                    break;
                case NUTRACEUTIQUES:
                    nutraceutiques++;
                    break;
                case ALIMENTATION:
                    alimentation++;
                    break;
                case EQUIPEMENT_MEDICAL:
                    equipementMedical++;
                    break;
                case DIAGNOSTIC:
                    diagnostic++;
                    break;
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Medicament", medicament);
        map.put("Dispositif Medical", dispositifMedical);
        map.put("Soins Personnels", soinsPersonnels);
        map.put("Nutraceutiques", nutraceutiques);
        map.put("Alimentation", alimentation);
        map.put("Equipement Medical", equipementMedical);
        map.put("Diagnostic", diagnostic);
        map.put("Total", allCategories.size());

        return map;
    }

}
