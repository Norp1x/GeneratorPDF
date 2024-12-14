package org.example.domain.fields.mapper.general;

import org.example.domain.dto.general.PdfRequestActionTypes;
import org.example.domain.fields.sections.general.ActionTypesSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestActionTypesMapper {

    ActionTypesSection map(PdfRequestActionTypes pdfRequestActionTypes);
}
