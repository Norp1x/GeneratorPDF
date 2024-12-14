package org.example.infrastructure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "meters")
public class MetersConfig {

    private String cf51;
    private String cf55;
    private String cfEcho;
    private String lec5;
    private String faun;
    private String lqm;
    private String scylar;
    private String multical403;
    private String multical603;
}
