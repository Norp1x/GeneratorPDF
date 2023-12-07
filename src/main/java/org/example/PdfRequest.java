package org.example;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PdfRequest {

    public static String actionType1;
    public static String actionType2;
    @NotNull
    public static String address;
    public static String date;
    public static String energy;
    public static String water;
    public static String flowConverter;
    @NotNull
    public static String meterDismantled;
    public static String meterDismantledSerialNumber;
    public static String meterDismantledProductionYear;
    public static String meterDismantledRadioAddress;
    public static String meterDismantledImpulse;
    @NotNull
    public static String meterInstalled;
    public static String meterInstalledSerialNumber;
    public static String meterInstalledProductionYear;
    public static String meterInstalledRadioAddress;
    public static String meterInstalledImpulse;
    public static String meterInstalledLegalizationDate;
    public static String flowMeterDismantled;
    public static String flowMeterDismantledSerialNumber;
    public static String flowMeterDismantledProductionYear;
    public static String flowMeterDismantledQN;
    public static String flowMeterDismantledDN;
    public static String flowMeterDismantledImpulse;
    public static String flowmeterInstalled;
    public static String flowMeterInstalledSerialNumber;
    public static String flowMeterInstalledProductionYear;
    public static String flowMeterInstalledQN;
    public static String flowMeterInstalledDN;
    public static String flowMeterInstalledImpulse;
    public static String flowMeterInstalledLegalizationDate;

    public PdfRequest(String actionType1,
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
                      String flowMeterInstalledSerialNumber,
                      String flowMeterInstalledProductionYear,
                      String flowMeterInstalledQN,
                      String flowMeterInstalledDN,
                      String flowMeterInstalledImpulse,
                      String flowMeterInstalledLegalizationDate) {
        PdfRequest.actionType1 = actionType1;
        PdfRequest.actionType2 = actionType2;
        PdfRequest.address = address;
        PdfRequest.date = date;
        PdfRequest.energy = energy;
        PdfRequest.water = water;
        PdfRequest.flowConverter = flowConverter;
        PdfRequest.meterDismantled = meterDismantled;
        PdfRequest.meterDismantledSerialNumber = meterDismantledSerialNumber;
        PdfRequest.meterDismantledProductionYear = meterDismantledProductionYear;
        PdfRequest.meterDismantledRadioAddress = meterDismantledRadioAddress;
        PdfRequest.meterDismantledImpulse = meterDismantledImpulse;
        PdfRequest.meterInstalled = meterInstalled;
        PdfRequest.meterInstalledSerialNumber = meterInstalledSerialNumber;
        PdfRequest.meterInstalledProductionYear = meterInstalledProductionYear;
        PdfRequest.meterInstalledRadioAddress = meterInstalledRadioAddress;
        PdfRequest.meterInstalledImpulse = meterInstalledImpulse;
        PdfRequest.meterInstalledLegalizationDate = meterInstalledLegalizationDate;
        PdfRequest.flowMeterDismantled = flowMeterDismantled;
        PdfRequest.flowMeterDismantledSerialNumber = flowMeterDismantledSerialNumber;
        PdfRequest.flowMeterDismantledProductionYear = flowMeterDismantledProductionYear;
        PdfRequest.flowMeterDismantledQN = flowMeterDismantledQN;
        PdfRequest.flowMeterDismantledDN = flowMeterDismantledDN;
        PdfRequest.flowMeterDismantledImpulse = flowMeterDismantledImpulse;
        PdfRequest.flowmeterInstalled = flowmeterInstalled;
        PdfRequest.flowMeterInstalledSerialNumber = flowMeterInstalledSerialNumber;
        PdfRequest.flowMeterInstalledProductionYear = flowMeterInstalledProductionYear;
        PdfRequest.flowMeterInstalledQN = flowMeterInstalledQN;
        PdfRequest.flowMeterInstalledDN = flowMeterInstalledDN;
        PdfRequest.flowMeterInstalledImpulse = flowMeterInstalledImpulse;
        PdfRequest.flowMeterInstalledLegalizationDate = flowMeterInstalledLegalizationDate;
    }

    public String getActionType1() {
        return actionType1;
    }
    public String getActionType2() {
        return actionType2;
    }
    public String getAddress() {
        return address;
    }
    public String getDate() {
        return date;
    }
    public String getEnergy() {
        return energy;
    }
    public String getWater() {
        return water;
    }
    public String getFlowConverter() {
        return flowConverter;
    }
    public String getMeterDismantled() {
        return meterDismantled;
    }
    public String getMeterDismantledSerialNumber() {
        return meterDismantledSerialNumber;
    }
    public String getMeterDismantledProductionYear() {
        return meterDismantledProductionYear;
    }
    public String getMeterDismantledRadioAddress() {
        return meterDismantledRadioAddress;
    }
    public String getMeterDismantledImpulse() {
        return meterDismantledImpulse;
    }
    public String getMeterInstalled() {
        return meterInstalled;
    }
    public String getMeterInstalledSerialNumber() {
        return meterInstalledSerialNumber;
    }
    public String getMeterInstalledProductionYear() {
        return meterInstalledProductionYear;
    }
    public String getMeterInstalledRadioAddress() {
        return meterInstalledRadioAddress;
    }
    public String getMeterInstalledImpulse() {
        return meterInstalledImpulse;
    }
    public String getMeterInstalledLegalizationDate() {
        return meterInstalledLegalizationDate;
    }
    public static String getFlowMeterDismantled() {
        return flowMeterDismantled;
    }

    public static String getFlowMeterDismantledSerialNumber() {
        return flowMeterDismantledSerialNumber;
    }

    public static String getFlowMeterDismantledProductionYear() {
        return flowMeterDismantledProductionYear;
    }

    public static String getFlowMeterDismantledQN() {
        return flowMeterDismantledQN;
    }

    public static String getFlowMeterDismantledDN() {
        return flowMeterDismantledDN;
    }

    public static String getFlowMeterDismantledImpulse() {
        return flowMeterDismantledImpulse;
    }

    public static String getFlowmeterInstalled() {
        return flowmeterInstalled;
    }

    public static String getFlowMeterInstalledSerialNumber() {
        return flowMeterInstalledSerialNumber;
    }

    public static String getFlowMeterInstalledProductionYear() {
        return flowMeterInstalledProductionYear;
    }

    public static String getFlowMeterInstalledQN() {
        return flowMeterInstalledQN;
    }

    public static String getFlowMeterInstalledDN() {
        return flowMeterInstalledDN;
    }

    public static String getFlowMeterInstalledImpulse() {
        return flowMeterInstalledImpulse;
    }

    public static String getFlowMeterInstalledLegalizationDate() {
        return flowMeterInstalledLegalizationDate;
    }
}

