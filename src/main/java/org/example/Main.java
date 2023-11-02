package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.awt.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        File oldFile = new File("C:\\Users\\Norpi\\Desktop\\PD\\kopia1.pdf");
        PDDocument document1 = null;
        try {
            //wypisanie współrzędnych każdego znaku
            document1 = PDDocument.load(oldFile);
            PDFTextStripper stripper = new GetLocation();
            stripper.setSortByPosition(true);
            stripper.setStartPage(0);
            stripper.setEndPage(document1.getNumberOfPages());

            Writer letters = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document1, letters);

            //ustawianie czcionki
            PDPage firstPage = document1.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(document1, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
            contentStream.setLeading(16.0f);


            //wprowadzanie tekstu w określonych współrzędnych
            float y = 842;
            contentStream.setNonStrokingColor(Color.black);
            contentStream.newLineAtOffset(142, y - 206);
            contentStream.showText("Przykladowy adres");
            contentStream.endText();
            contentStream.close();

            document1.save("C:\\Users\\Norpi\\Desktop\\PD\\myPDF.pdf");
            System.out.println("PDF Created");
        } finally {
            if (document1 != null) {
                document1.close();
            }
        }
    }
}