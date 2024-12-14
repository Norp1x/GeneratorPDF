package org.example.domain.utils;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.IOException;
import java.util.List;

public class GetLocation extends PDFTextStripper {
    public GetLocation() throws IOException {
    }

    @Override
    protected void writeString(String string, List<TextPosition> textPositions) {
        for (TextPosition text : textPositions) {
            System.out.println(text.getUnicode() + " [ X=" + text.getXDirAdj() +
                    ", Y=" + text.getYDirAdj() + " ]");
        }

    }
}
