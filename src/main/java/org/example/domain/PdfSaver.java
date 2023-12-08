package org.example.domain;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
class PdfSaver {

    PdfFileInfo savePdf(final PDDocument pdfFile, final String address, final String savePath) throws IOException {
        String uuid = UUID.randomUUID().toString();
        String dateTime = new SimpleDateFormat("dd-MM-yyyy__HH-mm-ss").format(new Date());
        PdfName pdfName = new PdfName(dateTime + "__" + address + ".pdf");
        PdfSavedPath savedPath = new PdfSavedPath(savePath + pdfName.value());
        File toSave = new File(savedPath.value());
        pdfFile.save(toSave);
        pdfFile.close();
        System.out.println("PDF Created");
        return new PdfFileInfo(pdfName, uuid);
    }

    ByteArrayResource saveToFile(final String fileName, final String path) throws IOException {
        File oldFile = new File(path + fileName);
        return new ByteArrayResource(Files.readAllBytes(oldFile.toPath()));
    }
}
