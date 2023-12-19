package org.example.domain;

import lombok.AllArgsConstructor;
import org.example.infrastructure.FileConfiguration;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.List;

@Component
@AllArgsConstructor
public
class PdfFilesReader {

    private final FileConfiguration fileConfiguration;
    private final FilesLister listFilesInDirectory = new FilesLister();

    public LinkedHashSet<String> retrieveAllExistingFiles() {
        String path = fileConfiguration.existingGeneratedPdfFilesPath();
        List<String> files = listFilesInDirectory.listAllPdfFilesInDirectory(path);
        return new LinkedHashSet<>(files);
    }
}
