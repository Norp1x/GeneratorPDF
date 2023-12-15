package org.example.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@ConfigurationProperties(prefix = "pdf")
public class FileConfiguration{
    @Value("${pdf.fontPath}")
    private String fontPath;

    @Value("${pdf.readPath}")
    private String readPath;

    @Value("${pdf.savePath}")
    private String savePath;

    @Value("${pdf.existingGeneratedPdfFilesPath}")
    private String existingGeneratedPdfFilesPath;

    public String fontPath(){
        return formatPath(fontPath);
    }

    public String readPath(){
        return formatPath(readPath);
    }

    public String savePath(){
        return formatPath(savePath);
    }

    public String existingGeneratedPdfFilesPath(){
        return formatPath(existingGeneratedPdfFilesPath);
    }

    private String formatPath(String path){
        return path.replace("/", File.separator);
    }



}
