package org.example.domain.fields.sections.installed;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record InstalledFlowMetersSection(String flowMeterInstalled,
                                         String flowMeterInstalledSerialNumber,
                                         String flowMeterInstalledProductionYear,
                                         String flowMeterInstalledQN,
                                         String flowMeterInstalledDN,
                                         String flowMeterInstalledImpulse,
                                         String flowMeterInstalledLegalizationYear,
                                         String flowMeterInstalledLegalizationMonth) {
}
