package org.example.domain.fields.mapper.installed;

import org.example.domain.dto.installed.PdfRequestInstalledTempSensor;
import org.example.domain.fields.sections.installed.InstalledTempSensorSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestInstalledTempSensorMapper {

    InstalledTempSensorSection map(PdfRequestInstalledTempSensor pdfRequestInstalledTempSensor);
}
