package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        try {
            // Load the existing PDF form
            ClassLoader classLoader = Main.class.getClassLoader();
            InputStream pdfInputStream = classLoader.getResourceAsStream("prot_kopia.pdf");
            PDDocument pdfDocument = PDDocument.load(pdfInputStream);
            PDDocumentCatalog documentCatalog = pdfDocument.getDocumentCatalog();
            PDAcroForm acroForm = documentCatalog.getAcroForm();

            // Fill in the form fields
            PDField nameField = acroForm.getField("Name");
            nameField.setValue("John Doe");

            PDField emailField = acroForm.getField("Email");
            emailField.setValue("johndoe@example.com");

            // Save the filled PDF form
            pdfDocument.save("filled_form.pdf");
            pdfDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
