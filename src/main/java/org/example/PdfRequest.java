package org.example;
public class PdfRequest {
    public static String address;
    public static String meterDismantled;
    public static String meterInstalled;

    public PdfRequest(String address, String meterDismantled, String meterInstalled) {
        PdfRequest.address = address;
        PdfRequest.meterDismantled = meterDismantled;
        PdfRequest.meterInstalled = meterInstalled;
    }

    public String getAddress() {
        return address;
    }
    public String getMeterDismantled() {
        return meterDismantled;
    }

    public String getMeterInstalled() {
        return meterInstalled;
    }
}

