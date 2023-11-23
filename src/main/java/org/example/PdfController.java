package org.example;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.HashMap;
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
        model.addAttribute("PdfRequest", new PdfRequest("", "", ""));
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
        String address = pdfRequest.getAddress();
        String meterDismantled = pdfRequest.getMeterDismantled();
        String meterInstalled = pdfRequest.getMeterInstalled();
        PdfFileInfo fileToDownload = pdfGenerator.generatePDF(address, meterDismantled, meterInstalled);
        System.out.println(fileToDownload);
        savedFilesByUser.put(fileToDownload.id(), fileToDownload.fileName().value());
        return "redirect:/processform";
    }

    @GetMapping("/processform")
    public String showForm2(Model model) throws IOException {
        model.addAttribute("PdfRequest", new PdfRequest(PdfRequest.address,
                PdfRequest.meterDismantled,
                PdfRequest.meterInstalled));
        return "submitform";
    }
}
