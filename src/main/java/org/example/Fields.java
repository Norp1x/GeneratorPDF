package org.example;

import lombok.Builder;

@Builder
public record Fields(
        String actionType1,
        String actionType2,
        String address,
        String date,
        String energy,
        String water,
        String flowConverter,
        String meterDismantled,
        String meterDismantledSerialNumber,
        String meterDismantledProductionYear,
        String meterDismantledRadioAddress,
        String meterDismantledImpulse,
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
        String installedFlowMeterSerialNumber,
        String installedFlowMeterProductionYear,
        String installedFlowMeterQN,
        String installedFlowMeterDN,
        String installedFlowMeterImpulse,
        String installedFlowMeterLegalizationDate
) {
}
