package org.example.infrastructure.service;

import lombok.AllArgsConstructor;
import org.example.infrastructure.MetersConfig;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by Norpix on 14.12.2024.
 * Description:
 */
@Service
@AllArgsConstructor
public class ShowFormService {

    private final List<String> metersList;
    private final List<String> flowMetersList;
    private final MetersConfig metersConfig;

    public void prepareForm(Model model) {
        addMeters(model);
    }

    private void addMeters(Model model) {
        metersList.add(metersConfig.getCf51());
        metersList.add(metersConfig.getCf55());
        metersList.add(metersConfig.getCfEcho());
        metersList.add(metersConfig.getLec5());
        metersList.add(metersConfig.getFaun());
        metersList.add(metersConfig.getLqm());
        metersList.add(metersConfig.getScylar());
        metersList.add(metersConfig.getMultical403());
        metersList.add(metersConfig.getMultical603());
    }
}
