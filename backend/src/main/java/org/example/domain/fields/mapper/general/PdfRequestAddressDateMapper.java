package org.example.domain.fields.mapper.general;

import org.example.domain.dto.general.PdfRequestAddressDate;
import org.example.domain.fields.sections.general.AddressDateSection;
import org.mapstruct.Mapper;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Mapper
public interface PdfRequestAddressDateMapper {

    AddressDateSection map(PdfRequestAddressDate pdfRequestAddressDate);
}
