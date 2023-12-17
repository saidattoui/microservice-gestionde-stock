package com.esprit.msprojet.gestionproduits.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String codeBarre;
    private Double prixUnitaire;
    private String description;
    private Date dateExpiration;


    @ManyToOne //etudiant
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String codeBarre, Double prixUnitaire, String description, Date dateExpiration, Categorie categorie) {
        this.codeBarre = codeBarre;
        this.prixUnitaire = prixUnitaire;
        this.description = description;
        this.dateExpiration = dateExpiration;
        this.categorie = categorie;
    }

    public Produit(String codeBarre, Double prixUnitaire, String description, Date dateExpiration) {
        this.codeBarre = codeBarre;
        this.prixUnitaire = prixUnitaire;
        this.description = description;
        this.dateExpiration = dateExpiration;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
