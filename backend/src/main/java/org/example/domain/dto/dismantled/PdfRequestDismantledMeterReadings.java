package org.example.domain.dto.dismantled;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestDismantledMeterReadings(String energyReadingBefore,
                                                String waterReadingBefore,
                                                String flowConverterReadingBefore) {
}
