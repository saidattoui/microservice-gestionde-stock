package com.esprit.microservices.candidate.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Historique implements Serializable {
    private static final long serialverionUID=6;



    @Id
    @GeneratedValue
    private Long idHistorique;


    private Long prix;



    private Date date;
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
}
