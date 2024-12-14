package org.example.domain.dto.installed;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestInstalledMeter(String meterInstalled,
                                       String meterInstalledSerialNumber,
                                       String meterInstalledProductionYear,
                                       String meterInstalledRadioAddress,
                                       String meterInstalledImpulse,
                                       String meterInstalledLegalizationYear,
                                       String meterInstalledLegalizationMonth) {
}
