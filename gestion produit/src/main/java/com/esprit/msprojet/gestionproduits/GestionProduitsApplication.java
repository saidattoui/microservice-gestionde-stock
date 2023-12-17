package com.esprit.msprojet.gestionproduits;

import com.esprit.msprojet.gestionproduits.repositories.CategorieRepository;
import com.esprit.msprojet.gestionproduits.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEurekaClient
public class GestionProduitsApplication {



    public static void main(String[] args) {
        SpringApplication.run(GestionProduitsApplication.class, args);
    }


}
