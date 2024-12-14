package org.example.domain.dto.dismantled;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
public record PdfRequestDismantledFlowMeter(String flowMeterDismantled,
                                            String flowMeterDismantledSerialNumber,
                                            String flowMeterDismantledProductionYear,
                                            String flowMeterDismantledQN,
                                            String flowMeterDismantledDN,
                                            String flowMeterDismantledImpulse,
                                            String flowMeterDismantledLegalizationYear,
                                            String flowMeterDismantledLegalizationMonth) {
}
