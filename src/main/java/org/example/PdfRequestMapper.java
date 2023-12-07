package org.example;

class PdfRequestMapper {

    static Fields mapFromPdfRequestToFields(final PdfRequest pdfRequest) {
        return Fields.builder()
                .actionType1(pdfRequest.actionType1())
                .actionType2(pdfRequest.actionType2())
                .address(pdfRequest.address())
                .date(pdfRequest.date())
//        String actionType1 = pdfRequest.actionType1();
//        String actionType2 = pdfRequest.actionType2();
//        String address = pdfRequest.address();
//        String date = pdfRequest.date();
//        String energy = pdfRequest.energy();
//        String water = pdfRequest.water();
//        String flowConverter = pdfRequest.flowConverter();
//        String meterDismantled = pdfRequest.meterDismantled();
//        String meterDismantledSerialNumber = pdfRequest.meterDismantledSerialNumber();
//        String meterDismantledProductionYear = pdfRequest.meterDismantledProductionYear();
//        String meterDismantledRadioAddress = pdfRequest.meterDismantledRadioAddress();
//        String meterDismantledImpulse = pdfRequest.meterDismantledImpulse();
//        String meterInstalled = pdfRequest.meterInstalled();
//        String meterInstalledSerialNumber = pdfRequest.meterInstalledSerialNumber();
//        String meterInstalledProductionYear = pdfRequest.meterInstalledProductionYear();
//        String meterInstalledRadioAddress = pdfRequest.meterInstalledRadioAddress();
//        String meterInstalledImpulse = pdfRequest.meterInstalledImpulse();
//        String meterInstalledLegalizationDate = pdfRequest.meterInstalledLegalizationDate();
//        String flowMeterDismantled = pdfRequest.flowMeterDismantled();
//        String flowMeterDismantledSerialNumber = pdfRequest.flowMeterDismantledSerialNumber();
//        String flowMeterDismantledProductionYear = pdfRequest.flowMeterDismantledProductionYear();
//        String flowMeterDismantledQN = pdfRequest.flowMeterDismantledQN();
//        String flowMeterDismantledDN = pdfRequest.flowMeterDismantledDN();
//        String flowMeterDismantledImpulse = pdfRequest.flowMeterDismantledImpulse();
//        String flowmeterInstalled = pdfRequest.flowmeterInstalled();
//        String flowMeterInstalledSerialNumber = pdfRequest.flowMeterInstalledSerialNumber();
//        String flowMeterInstalledProductionYear = pdfRequest.flowMeterInstalledProductionYear();
//        String flowMeterInstalledQN = pdfRequest.flowMeterInstalledQN();
//        String flowMeterInstalledDN = pdfRequest.flowMeterInstalledDN();
//        String flowMeterInstalledImpulse = pdfRequest.flowMeterInstalledImpulse();
//        String flowMeterInstalledLegalizationDate = pdfRequest.flowMeterInstalledLegalizationDate();
                .build();
    }
}
