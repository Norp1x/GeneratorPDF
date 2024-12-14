package org.example.domain.utils;

import java.io.File;
import java.util.*;

public class FilesLister {
    public List<String> listAllPdfFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!(directory.exists() && directory.isDirectory())) {
            return Collections.emptyList();
        }
        List<String> files = Arrays.asList(Objects.requireNonNull(directory.list()));
        files.sort(Comparator.reverseOrder());
        return files;
    }
}
