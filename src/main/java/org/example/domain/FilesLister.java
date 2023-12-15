package org.example.domain;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class FilesLister {
    public List<String> listAllPdfFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!(directory.exists() && directory.isDirectory())) {
            return Collections.emptyList();
        }
        Set<String> uniqueSortedFiles = Arrays.stream(directory.listFiles())
                .map(File::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        return new ArrayList<>(uniqueSortedFiles);
    }
}
