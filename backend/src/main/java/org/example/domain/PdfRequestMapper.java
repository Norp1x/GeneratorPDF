package org.example.domain;

public class PdfRequestMapper {

    public static Fields mapFromPdfRequestToFields(final PdfRequest pdfRequest) {
        return Fields.builder()
                .actionType1(pdfRequest.actionType1())
                .actionType2(pdfRequest.actionType2())
                .address(pdfRequest.address())
                .date(pdfRequest.date())
                .energyBefore(pdfRequest.energyBefore())
                .waterBefore(pdfRequest.waterBefore())
                .flowConverterBefore(pdfRequest.flowConverterBefore())
                .meterDismantled(pdfRequest.meterDismantled())
                .meterDismantledSerialNumber(pdfRequest.meterDismantledSerialNumber())
                .meterDismantledProductionYear(pdfRequest.meterDismantledProductionYear())
                .meterDismantledRadioAddress(pdfRequest.meterDismantledRadioAddress())
                .meterDismantledImpulse(pdfRequest.meterDismantledImpulse())
                .meterDismantledLegalizationDate1(pdfRequest.meterDismantledLegalizationDate1())
                .meterInstalled(pdfRequest.meterInstalled())
                .meterInstalledSerialNumber(pdfRequest.meterInstalledSerialNumber())
                .meterInstalledProductionYear(pdfRequest.meterInstalledProductionYear())
                .meterInstalledRadioAddress(pdfRequest.meterInstalledRadioAddress())
                .meterInstalledImpulse(pdfRequest.meterInstalledImpulse())
                .meterInstalledLegalizationDate1(pdfRequest.meterInstalledLegalizationDate1())
                .meterInstalledLegalizationDate2(pdfRequest.meterInstalledLegalizationDate2())
                .flowMeterDismantled(pdfRequest.flowMeterDismantled())
                .flowMeterDismantledSerialNumber(pdfRequest.flowMeterDismantledSerialNumber())
                .flowMeterDismantledProductionYear(pdfRequest.flowMeterDismantledProductionYear())
                .flowMeterDismantledQN(pdfRequest.flowMeterDismantledQN())
                .flowMeterDismantledDN(pdfRequest.flowMeterDismantledDN())
                .flowMeterDismantledImpulse(pdfRequest.flowMeterDismantledImpulse())
                .flowMeterDismantledLegalizationDate1(pdfRequest.flowMeterDismantledLegalizationDate1())
                .flowMeterInstalled(pdfRequest.flowMeterInstalled())
                .flowMeterInstalledSerialNumber(pdfRequest.flowMeterInstalledSerialNumber())
                .flowMeterInstalledProductionYear(pdfRequest.flowMeterInstalledProductionYear())
                .flowMeterInstalledQN(pdfRequest.flowMeterInstalledQN())
                .flowMeterInstalledDN(pdfRequest.flowMeterInstalledDN())
                .flowMeterInstalledImpulse(pdfRequest.flowMeterInstalledImpulse())
                .flowMeterInstalledLegalizationDate1(pdfRequest.flowMeterInstalledLegalizationDate1())
                .flowMeterInstalledLegalizationDate2(pdfRequest.flowMeterInstalledLegalizationDate2())
                .tempSensorDismantledPT(pdfRequest.tempSensorDismantledPT())
                .tempSensorDismantledType(pdfRequest.tempSensorDismantledType())
                .tempSensorDismantledSerialNumber1(pdfRequest.tempSensorDismantledSerialNumber1())
                .tempSensorDismantledSerialNumber2(pdfRequest.tempSensorDismantledSerialNumber2())
                .tempSensorDismantledProductionYear(pdfRequest.tempSensorDismantledProductionYear())
                .tempSensorDismantledLegalizationDate1(pdfRequest.tempSensorDismantledLegalizationDate1())
                .tempSensorInstalledPT(pdfRequest.tempSensorInstalledPT())
                .tempSensorInstalledType(pdfRequest.tempSensorInstalledType())
                .tempSensorInstalledSerialNumber1(pdfRequest.tempSensorInstalledSerialNumber1())
                .tempSensorInstalledSerialNumber2(pdfRequest.tempSensorInstalledSerialNumber2())
                .tempSensorInstalledProductionYear(pdfRequest.tempSensorInstalledProductionYear())
                .tempSensorInstalledLegalizationDate1(pdfRequest.tempSensorInstalledLegalizationDate1())
                .tempSensorInstalledLegalizationDate2(pdfRequest.tempSensorInstalledLegalizationDate2())
                .otherActionsService(pdfRequest.otherActionsService())
                .energyAfter(pdfRequest.energyAfter())
                .waterAfter(pdfRequest.waterAfter())
                .flowConverterAfter(pdfRequest.flowConverterAfter())
                .build();
    }
}
