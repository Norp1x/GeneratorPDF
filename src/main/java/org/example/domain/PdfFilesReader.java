package org.example.domain;

import lombok.AllArgsConstructor;
import org.example.infrastructure.FileConfiguration;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public
class PdfFilesReader {

    private final FileConfiguration fileConfiguration;
    private final FilesLister listFilesInDirectory = new FilesLister();

    public Map<String, String> retrieveAllExistingFiles() {
        String path = fileConfiguration.existingGeneratedPdfFilesPath();
        List<String> files = listFilesInDirectory.listAllPdfFilesInDirectory(path);
        return files.stream()
                .collect(Collectors.toMap(
                        fileName -> UUID.randomUUID().toString(),
                        fileName -> fileName
                ));
    }
}
