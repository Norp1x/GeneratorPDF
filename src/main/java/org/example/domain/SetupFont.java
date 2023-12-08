package org.example.domain;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public class SetupFont {

    private final String fontFilePath;

    PDPageContentStream setupFont(PDPageContentStream contentStream, float fontSize) throws IOException {
        File fontFile = new File(fontFilePath); // "/home/ec2-user/static/DejaVuSerifCondensed-BoldItalic.ttf"
        contentStream.setFont(PDType0Font.load(new PDDocument(), fontFile), fontSize);
        contentStream.setLeading(16.0f);
        return contentStream;
    }
}
