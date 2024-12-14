package org.example.domain.fields.sections.dismantled;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record DismantledMetersSection(String meterDismantledType,
                                      String meterDismantledSerialNumber,
                                      String meterDismantledProductionYear,
                                      String meterDismantledRadioAddress,
                                      String meterDismantledImpulse,
                                      String meterDismantledLegalizationYear,
                                      String meterDismantledLegalizationMonth) {
}