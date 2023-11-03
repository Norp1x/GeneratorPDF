package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Main {
    static final float MAX_HEIGHT_OF_PDF_FILE_IN_PIXELS = 842;


    public static void main(String[] args) throws IOException {
        File oldFile = new File("G:\\Project\\src\\main\\resources\\PDF.pdf");
        PDDocument pdfFile = null;
        try {
            pdfFile = PDDocument.load(oldFile);
        } catch (Exception exception) {
            System.out.println("File not found");
        }
        assert pdfFile != null : "File is empty";
        PDPage firstPage = pdfFile.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream ABC = writeSampleAddressToPDF(contentStream, "Przykładowy adres", 142, 206);


        ABC.close();

        pdfFile.save("G:\\Project\\src\\main\\resources\\newPDF.pdf");
        System.out.println("PDF Created");
        pdfFile.close();
    }

    private static PDPageContentStream writeSampleAddressToPDF(PDPageContentStream contentStream, String textValue, int x, int y) throws IOException {
        contentStream.beginText();
        PDPageContentStream ABC = setupFont(contentStream);
        ABC.setNonStrokingColor(Color.black);
        ABC.newLineAtOffset(x, MAX_HEIGHT_OF_PDF_FILE_IN_PIXELS - y);
        ABC.showText(textValue);
        ABC.endText();
        return ABC;
    }

    private static PDPageContentStream setupFont(PDPageContentStream contentStream) throws IOException {
        File fontFile = new File("G:\\Project\\src\\main\\resources\\DejaVuSerifCondensed-BoldItalic.ttf");
        contentStream.setFont(PDType0Font.load(new PDDocument(), fontFile), 18);
        contentStream.setLeading(16.0f);
        return contentStream;
    }
}