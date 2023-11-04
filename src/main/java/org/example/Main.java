package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;


public class Main {
    static final float MAX_HEIGHT_OF_PDF_FILE_IN_PIXELS = 842;


    public static void main(String[] args) throws IOException {
        File oldFile = new File("src\\main\\resources\\PDF.pdf");
        PDDocument pdfFile = null;
        try {
            pdfFile = PDDocument.load(oldFile);
        } catch (Exception exception) {
            System.out.println("File not found");
        }
        assert pdfFile != null : "File is empty";
        PDPage firstPage = pdfFile.getPage(0);
        TextWriter textWriter = new TextWriter();

        PDPageContentStream addressLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream addressField = textWriter.textWriterPDF(addressLine, "Przykładowy adres", 142, 206);
        addressField.close();

        PDPageContentStream meterTypeColumn_1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream meterTypeDismantled = textWriter.textWriterPDF(meterTypeColumn_1, "CF 51", 135, 336);
        meterTypeDismantled.close();

        PDPageContentStream meterTypeColumn_2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream meterTypeInstalled = textWriter.textWriterPDF(meterTypeColumn_2, "CF 55", 135, 358);
        meterTypeInstalled.close();


        pdfFile.save("src\\main\\resources\\newPDF.pdf");
        System.out.println("PDF Created");
        pdfFile.close();
    }

}