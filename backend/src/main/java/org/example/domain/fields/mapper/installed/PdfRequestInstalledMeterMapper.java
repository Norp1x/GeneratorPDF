package org.example.domain.fields.mapper.installed;

import org.example.domain.dto.installed.PdfRequestInstalledMeter;
import org.example.domain.fields.sections.installed.InstalledMetersSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestInstalledMeterMapper {

    InstalledMetersSection map(PdfRequestInstalledMeter pdfRequestInstalledMeter);
}
