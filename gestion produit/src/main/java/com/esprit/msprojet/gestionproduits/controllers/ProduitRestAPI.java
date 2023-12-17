package com.esprit.msprojet.gestionproduits.controllers;

import com.esprit.msprojet.gestionproduits.entities.Categorie;
import com.esprit.msprojet.gestionproduits.entities.Produit;
import com.esprit.msprojet.gestionproduits.services.ProduitService;
import com.esprit.msprojet.gestionproduits.utilities.ExportExcelService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.TreeSet;

@RestController
@RequestMapping("/Produit")
public class ProduitRestAPI {
    private String title = "Bienvenue dans le Système de Gestion des Produits Pharmaceutiques";

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @Autowired
    private ProduitService produitService;
    ExportExcelService exportExcelService;

    @GetMapping
    public List<Produit> getListProduit() {
        return produitService.getAll();
    }

    @PostMapping("/addProduit")
    void addProduit(@RequestBody Produit produit) {
        produitService.addProduit(produit);
    }

    @DeleteMapping("/deleteProduit/{idProduit}")
    void deleteProduit(@PathVariable("idProduit") Long idProduit) {
        produitService.deleteProduitById(idProduit);
    }

    @PutMapping("/updateProduit/{idProduit}")
    void updateProduit(@PathVariable("idProduit") Long idProduit, @RequestBody Produit produit) {
        produitService.updateProduit(idProduit, produit);
    }

    @PutMapping("/assignCategorieToProduit/{idProduit}/{idCategorie}")
    public void assignCategorieToProduit(@PathVariable("idProduit") Long idProduit,
                                         @PathVariable("idCategorie") Long idCategorie) {
        produitService.assignCategorieToProduit(idProduit, idCategorie);
    }

    @GetMapping("/getProduit/{idProduit}")
    Produit getProduitById(@PathVariable("idProduit") Long idProduit) {
        return produitService.getProduitById(idProduit);
    }

    @GetMapping("getproduit/{codeBarre}")
    @ResponseBody
    public List<Produit> getProduitsByName(@PathVariable("codeBarre") String codeBarre) throws Exception, JsonMappingException, Exception {
        List<Produit> listP = produitService.retrieveAllProduitByCodeBarre(codeBarre);
        return listP;
    }

    @GetMapping("getproduits/asc")
    @ResponseBody
    public List<Produit> getProduitsAsc() {
        List<Produit> listP = produitService.retrieveAllProduitsByPrixUnitaireAsc();
        return listP;
    }

    @GetMapping("getproduits/desc")
    @ResponseBody
    public List<Produit> getProduitsDesc() {
        List<Produit> listP = produitService.retrieveAllProduitByPixUnitaireDesc();
        return listP;
    }


    @GetMapping("/export-excel")
    public ResponseEntity<byte[]> exportStudentsToExcel() {
        try {

            List<Produit> produits = produitService.getAll();
            ByteArrayOutputStream excelStream = exportExcelService.generateStudentsExcelReport(produits);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "produits.xlsx");
            return ResponseEntity.ok().headers(headers).body(excelStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors here, for example, by returning an HTTP error response
            return ResponseEntity.status(500).body(null);
        }
    }

}
