package org.example.domain;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class PdfGeneratorFacade {

    private final PdfSaver pdfSaver;

    public ByteArrayResource saveToFile(String fileName, String path) throws IOException {
        return pdfSaver.saveToFile(fileName, path);
    }
}
