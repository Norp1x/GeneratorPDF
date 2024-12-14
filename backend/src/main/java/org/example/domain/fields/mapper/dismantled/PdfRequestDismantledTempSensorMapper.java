package org.example.domain.fields.mapper.dismantled;

import org.example.domain.dto.dismantled.PdfRequestDismantledTempSensor;
import org.example.domain.fields.sections.dismantled.DismantledTempSensorsSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestDismantledTempSensorMapper {

    DismantledTempSensorsSection map(PdfRequestDismantledTempSensor pdfRequestDismantledTempSensor);
}
