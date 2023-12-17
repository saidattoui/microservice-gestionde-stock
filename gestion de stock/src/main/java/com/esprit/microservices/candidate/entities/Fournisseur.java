package com.esprit.microservices.candidate.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur implements Serializable {

    private static final long serialverionUID=6;

    @Id
    @GeneratedValue

    private Long idFournisseur;
    private String nom;
    private String adresse;
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur")
    private List<Historique> historiques = new ArrayList<>();


    }





