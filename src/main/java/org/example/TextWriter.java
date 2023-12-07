package org.example;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;
import java.io.IOException;

public class TextWriter {
    PDPageContentStream textWriterPDF(PDPageContentStream contentStream, String textValue, float x, float y, float fontSize) throws IOException {
        SetupFont setupFont = new SetupFont();
        contentStream.beginText();
        PDPageContentStream fontOptions = setupFont.setupFont(contentStream, fontSize);
        fontOptions.setNonStrokingColor(Color.black);
        fontOptions.newLineAtOffset(x, Main.MAX_HEIGHT_OF_PDF_FILE_IN_PIXELS - y);
        fontOptions.showText(textValue);
        fontOptions.endText();
        return fontOptions;
    }
}