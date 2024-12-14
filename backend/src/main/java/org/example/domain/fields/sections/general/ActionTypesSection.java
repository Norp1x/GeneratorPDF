package org.example.domain.fields.sections.general;

import lombok.Builder;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Builder
public record ActionTypesSection(String actionType,
                                 String readingMethod) {
}
