package com.example.gestioncommande.serviceImpl;

import com.example.gestioncommande.entity.Commande;
import com.example.gestioncommande.entity.StatCommande;
import com.example.gestioncommande.entity.StatutCommande;
import com.example.gestioncommande.repository.CommandeRepository;
import com.example.gestioncommande.service.CommandeService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;
//  @Autowired
  // private MailServiceImpl mailService;
    @Override
    public Commande addCommande(Commande commande) {
  //      try {
            //mailService.sendMail("ezzine.ahmed.98@gmail.com","commande","Commande Recu","bonjour votre commande est en cours");

    //    }catch (Exception e){
      //     System.out.println(e.getMessage());
       //}
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande){
        return commandeRepository.save(commande);


    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public List<Commande> listCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public  Commande getOneById(Long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public List<StatCommande> getStat() {
        List<Commande> livreList = commandeRepository.findByStatutCommande(StatutCommande.Livree);
        List<Commande> annuleeList = commandeRepository.findByStatutCommande(StatutCommande.Annulee);
        List<Commande> encoursList = commandeRepository.findByStatutCommande(StatutCommande.En_cours);

        StatCommande statCommandeLivre= new StatCommande(StatutCommande.Livree,livreList.size());
        StatCommande statCommandeAnnulee= new StatCommande(StatutCommande.Annulee,annuleeList.size());
        StatCommande statCommandeEncours= new StatCommande(StatutCommande.En_cours,encoursList.size());

        List<StatCommande> statCommandeList= new ArrayList<StatCommande>();
        statCommandeList.add(statCommandeLivre);
        statCommandeList.add(statCommandeAnnulee);
        statCommandeList.add(statCommandeEncours);

        return statCommandeList;
    }

    @Override
    public List<Commande> getOneByStaCommande(StatutCommande statutCommande) {
        return commandeRepository.findByStatutCommande(statutCommande);
    }


    public byte[] generateExcel(Integer stat) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            List<Commande> listCommande = new ArrayList<Commande>();
            if(stat==1){
                listCommande= commandeRepository.findByStatutCommande(StatutCommande.Livree);
            }else if(stat==2){
                listCommande=commandeRepository.findByStatutCommande(StatutCommande.Annulee);
            }else if(stat==3){
                listCommande=commandeRepository.findByStatutCommande(StatutCommande.En_cours);
            }else {
                listCommande=commandeRepository.findAll();
            }


            Sheet sheet = workbook.createSheet("Sheet1");
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Client");
            headerRow.createCell(1).setCellValue("Numero Commande");
            headerRow.createCell(2).setCellValue("Statut");

            int i =1;
            for(Commande c : listCommande){
                Row dataRow = sheet.createRow(i);
                dataRow.createCell(0).setCellValue(c.getClient().getNom() +" "+c.getClient().getPrenom());
                dataRow.createCell(1).setCellValue(c.getNumCommande());
                dataRow.createCell(2).setCellValue(c.getStatutCommande().toString());

                i=i+1;
            }


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
//////        Sheet sheet = workbook.createSheet("Sheet 1");

            // Create a header row
      //      Row headerRow = sheet.createRow(0);
        //    Cell headerCell = headerRow.createCell(0);
          //  headerCell.setCellValue("Data");

            // Create rows with data
            //for (int rowNum = 0; rowNum < data.size(); rowNum++) {
              //  Row row = sheet.createRow(rowNum + 1);
                //Cell cell = row.createCell(0);
                //cell.setCellValue(data.get(rowNum));
            //}

            // Write to ByteArrayOutputStream
            //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //workbook.write(outputStream);
            //return outputStream.toByteArray();
        //}
    //}


}
