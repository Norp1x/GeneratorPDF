package org.example.domain.fields.sections.dismantled;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record DismantledFlowMetersSection(String flowMeterDismantled,
                                          String flowMeterDismantledSerialNumber,
                                          String flowMeterDismantledProductionYear,
                                          String flowMeterDismantledQN,
                                          String flowMeterDismantledDN,
                                          String flowMeterDismantledImpulse,
                                          String flowMeterDismantledLegalizationYear,
                                          String flowMeterDismantledLegalizationMonth) {
}
