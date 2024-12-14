package org.example.domain.fields.mapper.dismantled;

import org.example.domain.dto.dismantled.PdfRequestDismantledFlowMeter;
import org.example.domain.fields.sections.dismantled.DismantledFlowMetersSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestDismantledFlowMeterMapper {

    DismantledFlowMetersSection map(PdfRequestDismantledFlowMeter pdfRequestDismantledFlowMeter);
}
