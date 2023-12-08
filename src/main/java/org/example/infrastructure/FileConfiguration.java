package org.example.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pdf")
public record FileConfiguration(
        String fontPath,
        String readPath,
        String savePath,
        String existingGeneratedPdfFilesPath
) {


}
