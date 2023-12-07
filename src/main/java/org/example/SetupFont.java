package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;

public class SetupFont {
    PDPageContentStream setupFont(PDPageContentStream contentStream, float fontSize) throws IOException {
        File fontFile = new File("G:\\Project\\src\\main\\resources\\DejaVuSerifCondensed-BoldItalic.ttf"); // "/home/ec2-user/static/DejaVuSerifCondensed-BoldItalic.ttf"
        contentStream.setFont(PDType0Font.load(new PDDocument(), fontFile), fontSize);
        contentStream.setLeading(16.0f);
        return contentStream;
    }
}
