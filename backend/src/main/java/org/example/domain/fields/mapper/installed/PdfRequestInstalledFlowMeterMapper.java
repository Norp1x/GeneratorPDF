package org.example.domain.fields.mapper.installed;

import org.example.domain.dto.installed.PdfRequestInstalledFlowMeter;
import org.example.domain.fields.sections.installed.InstalledFlowMetersSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestInstalledFlowMeterMapper {

    InstalledFlowMetersSection map(PdfRequestInstalledFlowMeter pdfRequestInstalledFlowMeter);
}
