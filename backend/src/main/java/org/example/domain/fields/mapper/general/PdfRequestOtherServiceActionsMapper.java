package org.example.domain.fields.mapper.general;

import org.example.domain.dto.general.PdfRequestOtherServiceActions;
import org.example.domain.fields.sections.general.OtherServiceActionsSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestOtherServiceActionsMapper {

    OtherServiceActionsSection map(PdfRequestOtherServiceActions pdfRequestOtherServiceActions);
}
