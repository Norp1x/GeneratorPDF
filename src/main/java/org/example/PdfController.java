package org.example;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class PdfController {
    private final Map<String, String> savedFilesByUser = new HashMap<>();

    private final PdfGenerator pdfGenerator;
    private final PdfSaver pdfSaver = new PdfSaver();

//    @Value("${pdf.file.path}")
//    public final String savePath;

    private final FileConfiguration fileConfiguration;

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
        List<String> qN = new ArrayList<String>();
        qN.add("1,5");
        qN.add("2,5");
        qN.add("3,5");
        qN.add("6");
        qN.add("10");
        qN.add("15");
        qN.add("40");
        model.addAttribute("qN", qN);
        List<String> dN = new ArrayList<String>();
        dN.add("15");
        dN.add("20");
        dN.add("25");
        dN.add("32");
        dN.add("40");
        dN.add("50");
        dN.add("80");
        model.addAttribute("dN", dN);
        List<String> sensorPT = new ArrayList<String>();
        sensorPT.add("100");
        sensorPT.add("500");
        model.addAttribute("sensorPT", sensorPT);
        List<String> sensorType = new ArrayList<String>();
        sensorType.add("TS 200");
        sensorType.add("TS 400");
        sensorType.add("TSH202");
        sensorType.add("TOP-E 41");
        sensorType.add("TOP 146.1");
        sensorType.add("TOP 146.2");
        sensorType.add("TOP 1068");
        sensorType.add("61-63-D0-052-218");
        sensorType.add("61-63-D0-082-218");
        model.addAttribute("sensorType", sensorType);
        model.addAttribute("PdfRequest", new PdfRequest("legalization", "auto", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "", "",
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
        return pdfSaver.saveToFile(fileName, fileConfiguration.savePath());
    }

    @PostMapping("/generatepdf")
    public String generatePDF(@ModelAttribute PdfRequest pdfRequest, Model model) throws IOException {
        Fields fields = PdfRequestMapper.mapFromPdfRequestToFields(pdfRequest);
        model.addAttribute("PdfRequest", fields);
        PdfFileInfo fileToDownload = pdfGenerator.generatePDF(fields);
        System.out.println(fileToDownload);
        savedFilesByUser.put(fileToDownload.id(), fileToDownload.fileName().value());
        return "redirect:/files";
    }

    @GetMapping("/processform")
    public String showForm2(@ModelAttribute("PdfRequest") PdfRequest pdfRequest, Model model) throws IOException {
        Fields fields = PdfRequestMapper.mapFromPdfRequestToFields(pdfRequest);
        model.addAttribute("pdfRequest", fields);
        return "submitform";
    }
}
