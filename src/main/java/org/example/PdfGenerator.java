package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class PdfGenerator {

    public static final String SAVE_PATH = "/Users/bartlomiejkalka/Downloads/asdasd/src/main/resources/static/";
    public static final String READ_FILE_PATH = "/Users/bartlomiejkalka/Downloads/asdasd/src/main/resources/static/";

    PdfFileInfo generatePDF(String address, String meterDismantled, String meterInstalled) throws IOException {
        PDDocument pdfFile = readTemplatePdf();
        PDPage firstPage = pdfFile.getPage(0);
        TextWriter textWriter = new TextWriter();

        PDPageContentStream addressLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream addressField = textWriter.textWriterPDF(addressLine, address, 142, 206);
        addressField.close();

        PDPageContentStream meterTypeColumn_1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream meterTypeDismantled = textWriter.textWriterPDF(meterTypeColumn_1, meterDismantled, 135, 336);
        meterTypeDismantled.close();

        PDPageContentStream meterTypeColumn_2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream meterTypeInstalled = textWriter.textWriterPDF(meterTypeColumn_2, meterInstalled, 135, 358);
        meterTypeInstalled.close();

        return savePdf(pdfFile);
    }

    private PDDocument readTemplatePdf() {
        File oldFile = new File(READ_FILE_PATH + "PDF.pdf");
        PDDocument pdfFile = null;
        try {
            pdfFile = PDDocument.load(oldFile);
        } catch (Exception exception) {
            System.out.println("File not found");
        }
        assert pdfFile != null : "File is empty";
        return pdfFile;
    }

    private PdfFileInfo savePdf(final PDDocument pdfFile) throws IOException {
        String uuid = UUID.randomUUID().toString();
        PdfName pdfName = new PdfName("newPDF" + uuid + ".pdf");
        PdfSavedPath savePath = new PdfSavedPath(SAVE_PATH + pdfName.value());
        File toSave = new File(savePath.value());
        pdfFile.save(toSave);
        pdfFile.close();
        System.out.println("PDF Created");
        return new PdfFileInfo(pdfName, uuid);
    }
}
