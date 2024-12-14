package org.example.domain.fields.sections.installed;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record InstalledTempSensorSection(String tempSensorInstalledPT,
                                         String tempSensorInstalledType,
                                         String tempSensorInstalledSerialNumber1,
                                         String tempSensorInstalledSerialNumber2,
                                         String tempSensorInstalledProductionYear,
                                         String tempSensorInstalledLegalizationYear,
                                         String tempSensorInstalledLegalizationMonth) {
}
