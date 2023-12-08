package org.example.domain;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FilesLister {
    public List<String> listAllPdfFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!(directory.exists() && directory.isDirectory())) {
            return Collections.emptyList();
        }
        return Arrays.stream(directory.listFiles())
                .map(File::getName)
                .collect(Collectors.toList());
    }
}
