package com.esprit.msprojet.gestionproduits.utilities;
import com.esprit.msprojet.gestionproduits.entities.Produit;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ExportExcelService {

    public static ByteArrayOutputStream generateStudentsExcelReport(List<Produit> produits) {
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Sheet sheet = workbook.createSheet("Produits");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Code à barre", "Description", "Date Expiration", "PrixUnitaire","Nom du catégorie","Type de categorie"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Create data rows
            int rowNum = 1;
            for (Produit produit : produits) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(produit.getIdProduit());
                row.createCell(1).setCellValue(produit.getCodeBarre());
                row.createCell(2).setCellValue(produit.getDescription());
                row.createCell(3).setCellValue(produit.getDateExpiration().toString());
                row.createCell(4).setCellValue(produit.getPrixUnitaire());
                row.createCell(5).setCellValue(produit.getCategorie().getNom());
                row.createCell(6).setCellValue(produit.getCategorie().getType().name());


            }

            // Auto-size columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return out;
    }
}
