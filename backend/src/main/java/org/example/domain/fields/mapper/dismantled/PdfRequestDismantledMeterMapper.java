package org.example.domain.fields.mapper.dismantled;

import org.example.domain.dto.dismantled.PdfRequestDismantledMeter;
import org.example.domain.fields.sections.dismantled.DismantledMetersSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestDismantledMeterMapper {

    DismantledMetersSection map(PdfRequestDismantledMeter pdfRequestDismantledMeter);
}
