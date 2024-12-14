package org.example.domain;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Slf4j
@Component
public class PdfSaver {

    PdfFileInfo savedPdf(PDDocument pdfFile, String address, String savePath) throws IOException {
        String id = String.valueOf(System.currentTimeMillis());
        String dateTime = new SimpleDateFormat("dd-MM-yyyy__HH:mm:ss").format(new Date());
        PdfName pdfName = new PdfName(dateTime + "__" + address + ".pdf");
        PdfSavedPath savedPath = new PdfSavedPath(savePath + pdfName.value());
        File toSave = new File(savedPath.value());
        pdfFile.save(toSave);
        pdfFile.close();
        log.info("Saved PDF to {}", toSave);
        return new PdfFileInfo(pdfName, id);
    }

    ByteArrayResource saveToFile(String fileName, String savePath) throws IOException {
        File oldFile = new File(savePath + fileName);
        return new ByteArrayResource(Files.readAllBytes(oldFile.toPath()));
    }
}
