package org.example;

import jakarta.validation.Valid;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.PdfGenerator.SAVE_PATH;

@Controller
public class PdfController {
    Map<String, String> savedFilesByUser = new HashMap<>();

    private final PdfGenerator pdfGenerator;

    PdfController(final PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    @GetMapping("/generatepdf")
    public String showForm(Model model) {
        List<String> meters = new ArrayList<String>();
        meters.add("CF 51");
        meters.add("CF 55");
        meters.add("CF ECHO");
        meters.add("LEC 5");
        meters.add("FAUN");
        meters.add("LQM-III");
        meters.add("SCYLAR 548");
        meters.add("MULTICAL 403");
        meters.add("MULTICAL 603");
        model.addAttribute("meters", meters);
        List<String> impulse = new ArrayList<String>();
        impulse.add("2,5");
        impulse.add("5");
        impulse.add("7,5");
        impulse.add("10");
        impulse.add("15");
        impulse.add("25");
        impulse.add("50");
        impulse.add("100");
        impulse.add("500");
        model.addAttribute("impulse", impulse);
        List<String> flowMeters = new ArrayList<String>();
        flowMeters.add("US ECHO II");
        flowMeters.add("CF ECHO II");
        flowMeters.add("SONO 2500CT");
        flowMeters.add("SHARKY 473");
        flowMeters.add("ULTRA FLOW 54");
        flowMeters.add("AXONIC");
        flowMeters.add("UNICO 2");
        model.addAttribute("flowMeters", flowMeters);
        model.addAttribute("PdfRequest", new PdfRequest("legalization",
                "auto", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", ""));
        return "home";
    }

    @GetMapping("/files")
    public String showAllFiles(Model model) {
        model.addAttribute("userFilePath", savedFilesByUser);
        return "files";
    }

    @GetMapping(value = "/static/{fileName}", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody Resource getFileViaByteArrayResource(@PathVariable String fileName) throws IOException, URISyntaxException {
        File oldFile = new File(SAVE_PATH + fileName);
        return new ByteArrayResource(Files.readAllBytes(oldFile.toPath()));
    }

    @PostMapping("/generatepdf")
    public String generatePDF(@ModelAttribute PdfRequest pdfRequest) throws IOException {
        String actionType1 = pdfRequest.getActionType1();
        String actionType2 = pdfRequest.getActionType2();
        String address = pdfRequest.getAddress();
        String date = pdfRequest.getDate();
        String energy = pdfRequest.getEnergy();
        String water = pdfRequest.getWater();
        String flowConverter = pdfRequest.getFlowConverter();
        String meterDismantled = pdfRequest.getMeterDismantled();
        String meterDismantledSerialNumber = pdfRequest.getMeterDismantledSerialNumber();
        String meterDismantledProductionYear = pdfRequest.getMeterDismantledProductionYear();
        String meterDismantledRadioAddress = pdfRequest.getMeterDismantledRadioAddress();
        String meterDismantledImpulse = pdfRequest.getMeterDismantledImpulse();
        String meterInstalled = pdfRequest.getMeterInstalled();
        String meterInstalledSerialNumber = pdfRequest.getMeterInstalledSerialNumber();
        String meterInstalledProductionYear = pdfRequest.getMeterInstalledProductionYear();
        String meterInstalledRadioAddress = pdfRequest.getMeterInstalledRadioAddress();
        String meterInstalledImpulse = pdfRequest.getMeterInstalledImpulse();
        String meterInstalledLegalizationDate = pdfRequest.getMeterInstalledLegalizationDate();
        String flowMeterDismantled = PdfRequest.getFlowMeterDismantled();
        String flowMeterDismantledSerialNumber = PdfRequest.getFlowMeterDismantledSerialNumber();
        String flowMeterDismantledProductionYear = PdfRequest.getFlowMeterDismantledProductionYear();
        String flowMeterDismantledQN = PdfRequest.getFlowMeterDismantledQN();
        String flowMeterDismantledDN = PdfRequest.getFlowMeterDismantledDN();
        String flowMeterDismantledImpulse = PdfRequest.getFlowMeterDismantledImpulse();
        String flowmeterInstalled = PdfRequest.getFlowmeterInstalled();
        String flowMeterInstalledSerialNumber = PdfRequest.getFlowMeterInstalledSerialNumber();
        String flowMeterInstalledProductionYear = PdfRequest.getFlowMeterInstalledProductionYear();
        String flowMeterInstalledQN = PdfRequest.getFlowMeterInstalledQN();
        String flowMeterInstalledDN = PdfRequest.getFlowMeterInstalledDN();
        String flowMeterInstalledImpulse = PdfRequest.getFlowMeterInstalledImpulse();
        String flowMeterInstalledLegalizationDate = PdfRequest.getFlowMeterInstalledLegalizationDate();
        PdfFileInfo fileToDownload = pdfGenerator.generatePDF(actionType1,
                actionType2,
                address,
                date,
                energy,
                water,
                flowConverter,
                meterDismantled,
                meterDismantledSerialNumber,
                meterDismantledProductionYear,
                meterDismantledRadioAddress,
                meterDismantledImpulse,
                meterInstalled,
                meterInstalledSerialNumber,
                meterInstalledProductionYear,
                meterInstalledRadioAddress,
                meterInstalledImpulse,
                meterInstalledLegalizationDate,
                flowMeterDismantled,
                flowMeterDismantledSerialNumber,
                flowMeterDismantledProductionYear,
                flowMeterDismantledQN,
                flowMeterDismantledDN,
                flowMeterDismantledImpulse,
                flowmeterInstalled,
                flowMeterInstalledSerialNumber,
                flowMeterInstalledProductionYear,
                flowMeterInstalledQN,
                flowMeterInstalledDN,
                flowMeterInstalledImpulse,
                flowMeterInstalledLegalizationDate);
        System.out.println(fileToDownload);
        savedFilesByUser.put(fileToDownload.id(), fileToDownload.fileName().value());
        return "redirect:/processform";
    }

    @GetMapping("/processform")
    public String showForm2(Model model) throws IOException {
        model.addAttribute("PdfRequest", new PdfRequest(PdfRequest.actionType1,
                PdfRequest.actionType2,
                PdfRequest.address,
                PdfRequest.date,
                PdfRequest.energy,
                PdfRequest.water,
                PdfRequest.flowConverter,
                PdfRequest.meterDismantled,
                PdfRequest.meterDismantledSerialNumber,
                PdfRequest.meterDismantledProductionYear,
                PdfRequest.meterDismantledRadioAddress,
                PdfRequest.meterDismantledImpulse,
                PdfRequest.meterInstalled,
                PdfRequest.meterInstalledSerialNumber,
                PdfRequest.meterInstalledProductionYear,
                PdfRequest.meterInstalledRadioAddress,
                PdfRequest.meterInstalledImpulse,
                PdfRequest.meterInstalledLegalizationDate,
                PdfRequest.flowMeterDismantled,
                PdfRequest.flowMeterDismantledSerialNumber,
                PdfRequest.flowMeterDismantledProductionYear,
                PdfRequest.flowMeterDismantledQN,
                PdfRequest.flowMeterDismantledDN,
                PdfRequest.flowMeterDismantledImpulse,
                PdfRequest.flowmeterInstalled,
                PdfRequest.flowMeterInstalledSerialNumber,
                PdfRequest.flowMeterInstalledProductionYear,
                PdfRequest.flowMeterInstalledQN,
                PdfRequest.flowMeterInstalledDN,
                PdfRequest.flowMeterInstalledImpulse,
                PdfRequest.flowMeterInstalledLegalizationDate));
        return "submitform";
    }
}
