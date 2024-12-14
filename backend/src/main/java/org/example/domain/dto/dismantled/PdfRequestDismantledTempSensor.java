package org.example.domain.dto.dismantled;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestDismantledTempSensor(String tempSensorDismantledPT,
                                             String tempSensorDismantledType,
                                             String tempSensorDismantledSerialNumber1,
                                             String tempSensorDismantledSerialNumber2,
                                             String tempSensorDismantledProductionYear,
                                             String tempSensorDismantledLegalizationYear,
                                             String tempSensorDismantledLegalizationMonth) {
}
