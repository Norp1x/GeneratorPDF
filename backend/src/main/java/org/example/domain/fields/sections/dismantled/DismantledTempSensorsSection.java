package org.example.domain.fields.sections.dismantled;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record DismantledTempSensorsSection(String tempSensorDismantledPT,
                                           String tempSensorDismantledType,
                                           String tempSensorDismantledSerialNumber1,
                                           String tempSensorDismantledSerialNumber2,
                                           String tempSensorDismantledProductionYear,
                                           String tempSensorDismantledLegalizationYear,
                                           String tempSensorDismantledLegalizationMonth) {
}
