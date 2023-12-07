package org.example;

import jakarta.validation.constraints.NotNull;

public record PdfRequest(
        String actionType1,
        String actionType2,
        @NotNull
        String address,
        String date,
        String energy,
        String water,
        String flowConverter,
        @NotNull
        String meterDismantled,
        String meterDismantledSerialNumber,
        String meterDismantledProductionYear,
        String meterDismantledRadioAddress,
        String meterDismantledImpulse,
        @NotNull
        String meterInstalled,
        String meterInstalledSerialNumber,
        String meterInstalledProductionYear,
        String meterInstalledRadioAddress,
        String meterInstalledImpulse,
        String meterInstalledLegalizationDate,
        String flowMeterDismantled,
        String flowMeterDismantledSerialNumber,
        String flowMeterDismantledProductionYear,
        String flowMeterDismantledQN,
        String flowMeterDismantledDN,
        String flowMeterDismantledImpulse,
        String flowmeterInstalled,
        String flowMeterInstalledSerialNumber,
        String flowMeterInstalledProductionYear,
        String flowMeterInstalledQN,
        String flowMeterInstalledDN,
        String flowMeterInstalledImpulse,
        String flowMeterInstalledLegalizationDate
) {

}

