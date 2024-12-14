package org.example.domain.fields.sections.dismantled;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record DismantledMetersReadingsSection(String energyReadingBefore,
                                              String waterReadingBefore,
                                              String flowConverterReadingBefore) {
}
