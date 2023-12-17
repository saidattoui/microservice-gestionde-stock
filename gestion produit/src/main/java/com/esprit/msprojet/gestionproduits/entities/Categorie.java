package com.esprit.msprojet.gestionproduits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nom;
    private String codeCategorie;
    @Enumerated(EnumType.STRING)
    TypeCategorie type;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "categorie")//departement
    @JsonIgnore
    private List<Produit> produits;

    public Categorie() {
    }

    public Categorie(String nom, String codeCategorie, TypeCategorie type) {
        this.nom = nom;
        this.codeCategorie = codeCategorie;
        this.type = type;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(String codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public TypeCategorie getType() {
        return type;
    }

    public void setType(TypeCategorie type) {
        this.type = type;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
