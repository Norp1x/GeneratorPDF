package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class PdfController {
    @GetMapping("/generatepdf")
    public String showForm(Model model) {
        model.addAttribute("PdfRequest", new PdfRequest("", "", ""));
        return "home";
    }

    @PostMapping("/generatepdf")
    public String generatePDF(@ModelAttribute PdfRequest pdfRequest) throws IOException {
        PdfGenerator pdfGenerator = new PdfGenerator();
        String address = pdfRequest.getAddress();
        String meterDismantled = pdfRequest.getMeterDismantled();
        String meterInstalled = pdfRequest.getMeterInstalled();
        pdfGenerator.generatePDF(address, meterDismantled, meterInstalled);
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