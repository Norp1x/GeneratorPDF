package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {
    static final float MAX_HEIGHT_OF_PDF_FILE_IN_PIXELS = 842;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);

    }

}