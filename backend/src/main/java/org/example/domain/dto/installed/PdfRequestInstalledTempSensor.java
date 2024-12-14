package org.example.domain.dto.installed;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestInstalledTempSensor(String tempSensorInstalledPT,
                                            String tempSensorInstalledType,
                                            String tempSensorInstalledSerialNumber1,
                                            String tempSensorInstalledSerialNumber2,
                                            String tempSensorInstalledProductionYear,
                                            String tempSensorInstalledLegalizationYear,
                                            String tempSensorInstalledLegalizationMonth) {
}
