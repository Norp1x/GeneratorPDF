package org.example.domain.dto.installed;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestInstalledMeterReadings(String energyAfter,
                                               String waterAfter,
                                               String flowConverterAfter) {
}
