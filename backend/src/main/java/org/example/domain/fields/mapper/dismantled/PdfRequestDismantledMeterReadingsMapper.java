package org.example.domain.fields.mapper.dismantled;

import org.example.domain.dto.dismantled.PdfRequestDismantledMeterReadings;
import org.example.domain.fields.sections.dismantled.DismantledMetersReadingsSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestDismantledMeterReadingsMapper {

    DismantledMetersReadingsSection map(PdfRequestDismantledMeterReadings pdfRequestDismantledMeterReadings);
}
