package com.example.miniprojet.Service;
import com.example.miniprojet.Entity.Emplacement;
import com.example.miniprojet.Repository.EmplacementRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
@Service
public class EmplacementService implements IEmplacementService{
    @Autowired
    private EmplacementRepository emplacementRepository;
    @Override
    public List<Emplacement> getAllEmplacements() {
        return emplacementRepository.findAll();
    }

    @Override
    public Emplacement getEmplacementById(Long id) {
        return emplacementRepository.findById(id).orElse(null);
    }

    @Override
    public Emplacement saveEmplacement(Emplacement emplacement) {
        return emplacementRepository.save(emplacement);
    }

    @Override
    public void deleteEmplacement(Long id) {
        emplacementRepository.deleteById(id);

    }

    @Override
    /*
    public byte[] generatePdfForEmplacements(List<Emplacement> emplacements) throws DocumentException {
        if (emplacements == null || emplacements.isEmpty()) {
            // Gérer le cas où la liste d'emplacement est vide
            // Vous pouvez lever une exception, renvoyer un message d'erreur, etc.
            // Dans cet exemple, je vais simplement renvoyer un document PDF vide.
            return new byte[0];
        }

        // Créer un document PDF
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();

            // Ajouter le contenu au document
            document.add(new Paragraph("Liste des emplacements :"));

            for (Emplacement emplacement : emplacements) {
                document.add(new Paragraph("Nom: " + emplacement.getNom()));
                document.add(new Paragraph("Adresse: " + emplacement.getAdresse()));
                // Ajouter d'autres détails de l'emplacement selon vos besoins
                document.add(Chunk.NEWLINE);
            }

        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }
*/
    public byte[] generatePdfForEmplacements(List<Emplacement> emplacements) throws DocumentException {
        if (emplacements == null || emplacements.isEmpty()) {
            return new byte[0];
        }

        // Créer un document PDF
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();

            // Créer un tableau avec deux colonnes
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);

            // Ajouter le titre au tableau
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
            PdfPCell titleCell = new PdfPCell(new Phrase("Liste des emplacements :", titleFont));
            titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            titleCell.setColspan(2); // Étendre sur les deux colonnes
            titleCell.setBorder(Rectangle.NO_BORDER); // Pas de bordure
            table.addCell(titleCell);

            // Ajouter les détails de chaque emplacement au tableau
            for (Emplacement emplacement : emplacements) {
                PdfPCell nomCell = new PdfPCell(new Phrase("Nom: " + emplacement.getNom()));
                PdfPCell adresseCell = new PdfPCell(new Phrase("Adresse: " + emplacement.getAdresse()));

                // Ajouter les cellules au tableau
                table.addCell(nomCell);
                table.addCell(adresseCell);
            }

            // Ajouter le tableau au document
            document.add(table);

        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }

}



