package com.example.gestioncommande.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue
    private Long id;
    private Long numCommande;
    @ManyToMany(mappedBy = "commandes")
    private List<Produit> produits;
    private int quantite;
    private Double prix;
    @ManyToOne
    private Clients client;
    private StatutCommande statutCommande;

    public StatutCommande getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(StatutCommande statutCommande) {
        this.statutCommande = statutCommande;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(Long numCommande) {
        this.numCommande = numCommande;
    }

    public Commande(Long id, Long numCommande, List<Produit> produits, int quantite, Double prix, Clients client, StatutCommande statutCommande) {
        this.id = id;
        this.numCommande = numCommande;
        this.produits = produits;
        this.quantite = quantite;
        this.prix = prix;
        this.client = client;
        this.statutCommande = statutCommande;
    }

    public Commande() {
    }
}
