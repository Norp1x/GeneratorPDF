package org.example;
public class PdfRequest {
    private String address;
    private String meterDismantled;
    private String meterInstalled;

    public PdfRequest(String address, String meterDismantled, String meterInstalled) {
        this.address = address;
        this.meterDismantled = meterDismantled;
        this.meterInstalled = meterInstalled;
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

