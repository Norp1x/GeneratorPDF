package org.example.domain.fields.sections.installed;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record InstalledMetersReadingsSection(String energyAfter,
                                             String waterAfter,
                                             String flowConverterAfter) {
}
