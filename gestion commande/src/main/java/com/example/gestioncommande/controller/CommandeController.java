package com.example.gestioncommande.controller;

import com.example.gestioncommande.entity.Commande;
import com.example.gestioncommande.entity.StatCommande;
import com.example.gestioncommande.entity.StatutCommande;
import com.example.gestioncommande.serviceImpl.CommandeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeServiceImpl commandeService;
    @PostMapping("/save")
    public Commande saveCommande(@RequestBody Commande commande){
        return commandeService.addCommande(commande);
    }

    @PutMapping("/update")
    public Commande updCommande(@RequestBody Commande commande){
       return commandeService.updateCommande(commande);

    }
    @DeleteMapping("/delete/{commande-id}")
    public void  removeCommande(@PathVariable("commande-id") Long id) { commandeService.deleteCommande(id);}

    @GetMapping("/all")
    public List<Commande>  getAllCommande(){
        return  commandeService.listCommande();
    }

    @GetMapping("/byId/{id}")
    public Commande getOne(@PathVariable Long id){
        return commandeService.getOneById(id);
    }

    @GetMapping("/byStat/{statutCommande}")
    public List<Commande> getOneByStaCommande(@PathVariable StatutCommande statutCommande) {
        return  commandeService.getOneByStaCommande(statutCommande);
    }

    @GetMapping("StatCommande")
    public List<StatCommande> getStat() {
        return  commandeService.getStat();
    }


    @GetMapping("/download-excel/{num}")
    public ResponseEntity<byte[]> downloadExcel(@PathVariable Integer num) throws IOException {
        byte[] excelBytes = commandeService.generateExcel(num);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "data.xlsx");

        return new ResponseEntity<>(excelBytes, headers, org.springframework.http.HttpStatus.OK);
    }

  //  @GetMapping("/download-excel")
    //public ResponseEntity<byte[]> downloadExcel() throws IOException {
      //  List<String> data = Arrays.asList("Value 1", "Value 2", "Value 3");

        //byte[] excelBytes = commandeService.generateExcel(data);

        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //headers.setContentDispositionFormData("attachment", "data.xlsx");

        //return new ResponseEntity<>(excelBytes, headers, 200);
    //}

    }


