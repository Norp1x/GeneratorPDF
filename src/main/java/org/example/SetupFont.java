package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;

public class SetupFont {
    PDPageContentStream setupFont(PDPageContentStream contentStream) throws IOException {
        File fontFile = new File("src\\main\\resources\\DejaVuSerifCondensed-BoldItalic.ttf");
        contentStream.setFont(PDType0Font.load(new PDDocument(), fontFile), 18);
        contentStream.setLeading(16.0f);
        return contentStream;
    }
}
