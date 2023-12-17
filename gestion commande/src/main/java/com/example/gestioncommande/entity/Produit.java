package com.example.gestioncommande.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String description;
    private Double prix;
    private String photo;
    @ManyToMany
    private List<Commande> commandes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public Produit(Long id, String nom, String description, Double prix, String photo, List<Commande> commandes) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
        this.commandes = commandes;
    }

    public Produit() {
    }
}
