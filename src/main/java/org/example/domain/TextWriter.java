package org.example.domain;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;
import java.io.IOException;

@AllArgsConstructor
public class TextWriter {

    static final float MAX_HEIGHT_OF_PDF_FILE_IN_PIXELS = 842;

    private final String fontFilePath;

    PDPageContentStream textWriterPDF(PDPageContentStream contentStream, String textValue, float x, float y, float fontSize) throws IOException {
        SetupFont setupFont = new SetupFont(fontFilePath);
        contentStream.beginText();
        PDPageContentStream fontOptions = setupFont.setupFont(contentStream, fontSize);
        fontOptions.setNonStrokingColor(Color.black);
        fontOptions.newLineAtOffset(x, MAX_HEIGHT_OF_PDF_FILE_IN_PIXELS - y);
        fontOptions.showText(textValue);
        fontOptions.endText();
        return fontOptions;
    }
}
