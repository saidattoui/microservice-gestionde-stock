package com.esprit.msprojet.gestionproduits.controllers;

import com.esprit.msprojet.gestionproduits.entities.Categorie;
import com.esprit.msprojet.gestionproduits.entities.Produit;
import com.esprit.msprojet.gestionproduits.entities.TypeCategorie;
import com.esprit.msprojet.gestionproduits.services.CategorieService;
import com.esprit.msprojet.gestionproduits.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Categorie")
public class CategorieRestAPI {
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getListCategorie() {
        return categorieService.getAll();
    }

    @PostMapping("/addCategorie")
    void addCategorie(@RequestBody Categorie categorie) {
        categorieService.addCategorie(categorie);
    }

    @DeleteMapping("/deleteCategorie/{idCategorie}")
    void deleteCategorie(@PathVariable("idCategorie") Long idCategorie) {
        categorieService.deleteCategorieById(idCategorie);
    }

    @GetMapping("/getCategorie/{idCategorie}")
    Categorie getCategorieById(@PathVariable("idCategorie") Long idCategorie) {
        return categorieService.getCategorieById(idCategorie);
    }

    @PutMapping("/updateCategorie/{idCategorie}")
    void updateCategorie(@PathVariable("idCategorie") Long idCategorie, @RequestBody Categorie categorie) {
        categorieService.updateCategorie(idCategorie, categorie);
    }

    @GetMapping("/getCategoriesByType/{type}")
    public List<Categorie> getCategoriesByType(@PathVariable("type") TypeCategorie type) {
        return categorieService.getCategoriesByType(type);
    }

    @GetMapping("/stats")
    @ResponseBody
    public Map<String, Integer> getCategoriesStats() {
        return categorieService.categoriesStats();
    }
}
