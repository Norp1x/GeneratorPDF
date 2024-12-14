package org.example.domain.fields.mapper.installed;

import org.example.domain.dto.installed.PdfRequestInstalledMeterReadings;
import org.example.domain.fields.sections.installed.InstalledMetersReadingsSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestInstalledMeterReadingsMapper {

    InstalledMetersReadingsSection map(PdfRequestInstalledMeterReadings pdfRequestInstalledMeterReadings);
}
