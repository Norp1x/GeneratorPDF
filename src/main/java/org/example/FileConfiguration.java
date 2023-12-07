package org.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pdf")
record FileConfiguration(
        String fontPath,
        String readPath,
        String savePath
) {


}
