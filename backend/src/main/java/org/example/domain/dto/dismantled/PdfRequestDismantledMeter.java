package org.example.domain.dto.dismantled;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestDismantledMeter(String meterDismantledType,
                                        String meterDismantledSerialNumber,
                                        String meterDismantledProductionYear,
                                        String meterDismantledRadioAddress,
                                        String meterDismantledImpulse,
                                        String meterDismantledLegalizationYear,
                                        String meterDismantledLegalizationMonth) {
}
