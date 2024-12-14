package org.example.domain.fields.sections.installed;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record InstalledMetersSection(String meterInstalled,
                                     String meterInstalledSerialNumber,
                                     String meterInstalledProductionYear,
                                     String meterInstalledRadioAddress,
                                     String meterInstalledImpulse,
                                     String meterInstalledLegalizationYear,
                                     String meterInstalledLegalizationMonth) {
}
