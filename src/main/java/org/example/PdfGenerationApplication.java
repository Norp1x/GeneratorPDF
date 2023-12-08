package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PdfGenerationApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PdfGenerationApplication.class, args);

    }

}
