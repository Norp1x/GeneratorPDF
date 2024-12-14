package org.example.domain.dto.installed;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestInstalledFlowMeter(String flowMeterInstalled,
                                           String flowMeterInstalledSerialNumber,
                                           String flowMeterInstalledProductionYear,
                                           String flowMeterInstalledQN,
                                           String flowMeterInstalledDN,
                                           String flowMeterInstalledImpulse,
                                           String flowMeterInstalledLegalizationYear,
                                           String flowMeterInstalledLegalizationMonth) {
}
