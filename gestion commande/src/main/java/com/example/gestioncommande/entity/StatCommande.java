package com.example.gestioncommande.entity;

public class StatCommande {

    private StatutCommande statutCommande;
    private Integer nbCommande;

    public StatutCommande getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(StatutCommande statutCommande) {
        this.statutCommande = statutCommande;
    }

    public Integer getNbCommande() {
        return nbCommande;
    }

    public void setNbCommande(Integer nbCommande) {
        this.nbCommande = nbCommande;
    }

    public StatCommande(StatutCommande statutCommande, Integer nbCommande) {
        this.statutCommande = statutCommande;
        this.nbCommande = nbCommande;
    }

    public StatCommande() {
    }
}
