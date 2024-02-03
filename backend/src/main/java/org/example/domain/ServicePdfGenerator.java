package org.example.domain;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.example.infrastructure.FileConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@AllArgsConstructor
@EnableConfigurationProperties(FileConfiguration.class)
public class ServicePdfGenerator {

    private final FileConfiguration fileConfiguration;
    private final PdfSaver pdfSaver = new PdfSaver();

    public PdfFileInfo generatePDF(Fields fields) {
        try (PDDocument pdfFile = readTemplatePdf()) {
            PDPage firstPage = pdfFile.getPage(0);
            TextWriter textWriter = new TextWriter(fileConfiguration.fontPath());

            writeFromRadioButton1(fields.actionType1(), pdfFile, firstPage, textWriter);
            writeFromRadioButton2(fields.actionType2(), pdfFile, firstPage, textWriter);

            PDPageContentStream addressLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream addressField = textWriter.textWriterPDF(addressLine, fields.address(), 142, 205, 9);
            addressField.close();
            addressLine.close();

            PDPageContentStream dateLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dateField = textWriter.textWriterPDF(dateLine, fields.date(), 146, 230, 9);
            dateField.close();
            dateLine.close();

            PDPageContentStream readingsBeforeService1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream energyReadingsBefore = textWriter.textWriterPDF(readingsBeforeService1, fields.energyBefore(), 174, 275, 8);
            energyReadingsBefore.close();
            readingsBeforeService1.close();
            PDPageContentStream readingsBeforeService2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream waterReadingsBefore = textWriter.textWriterPDF(readingsBeforeService2, fields.waterBefore(), 291, 275, 8);
            waterReadingsBefore.close();
            readingsBeforeService2.close();
            PDPageContentStream readingsBeforeService3 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream flowConverterReadingsBefore = textWriter.textWriterPDF(readingsBeforeService3, fields.flowConverterBefore(), 471, 275, 8);
            flowConverterReadingsBefore.close();
            readingsBeforeService3.close();

            PDPageContentStream meterRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterType = textWriter.textWriterPDF(meterRow_1a, fields.meterDismantled(), 130, 333, 8);
            dismantledMeterType.close();
            meterRow_1a.close();

            PDPageContentStream meterRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterSerialNumber = textWriter.textWriterPDF(meterRow_1b, fields.meterDismantledSerialNumber(), 202, 333, 8);
            dismantledMeterSerialNumber.close();
            meterRow_1b.close();

            PDPageContentStream meterRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterProductionYear = textWriter.textWriterPDF(meterRow_1c, fields.meterDismantledProductionYear(), 341, 333, 8);
            dismantledMeterProductionYear.close();
            meterRow_1c.close();

            PDPageContentStream meterRow_1d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledRadioAddress = textWriter.textWriterPDF(meterRow_1d, fields.meterDismantledRadioAddress(), 397, 333, 8);
            dismantledRadioAddress.close();
            meterRow_1d.close();

            PDPageContentStream meterRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterImpulse = textWriter.textWriterPDF(meterRow_1e, fields.meterDismantledImpulse(), 470, 333, 8);
            dismantledMeterImpulse.close();
            meterRow_1e.close();

            PDPageContentStream meterRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterType = textWriter.textWriterPDF(meterRow_2a, fields.meterInstalled(), 130, 354, 8);
            installedMeterType.close();
            meterRow_2a.close();

            PDPageContentStream meterRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterSerialNumber = textWriter.textWriterPDF(meterRow_2b, fields.meterInstalledSerialNumber(), 202, 354, 8);
            installedMeterSerialNumber.close();
            meterRow_2b.close();

            PDPageContentStream meterRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterProductionYear = textWriter.textWriterPDF(meterRow_2c, fields.meterInstalledProductionYear(), 341, 354, 8);
            installedMeterProductionYear.close();
            meterRow_2c.close();

            PDPageContentStream meterRow_2d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterRadioAddress = textWriter.textWriterPDF(meterRow_2d, fields.meterInstalledRadioAddress(), 397, 354, 8);
            installedMeterRadioAddress.close();
            meterRow_2d.close();

            PDPageContentStream meterRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterImpulse = textWriter.textWriterPDF(meterRow_2e, fields.meterInstalledImpulse(), 470, 354, 8);
            installedMeterImpulse.close();
            meterRow_2e.close();

            PDPageContentStream meterRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterLegalizationDate1 = textWriter.textWriterPDF(meterRow_2f, fields.meterInstalledLegalizationDate1(), 515, 354, 8);
            installedMeterLegalizationDate1.close();
            meterRow_2f.close();

            PDPageContentStream meterRow_2g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterLegalizationDate2 = textWriter.textWriterPDF(meterRow_2g, "-" + fields.meterInstalledLegalizationDate2(), 535, 354, 8);
            installedMeterLegalizationDate2.close();
            meterRow_2g.close();

            PDPageContentStream flowMeterRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterType = textWriter.textWriterPDF(flowMeterRow_1a, fields.flowMeterDismantled(), 130, 413, 8);
            dismantledFlowMeterType.close();
            flowMeterRow_1a.close();

            PDPageContentStream flowMeterRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterSerialNumber = textWriter.textWriterPDF(flowMeterRow_1b, fields.flowMeterDismantledSerialNumber(), 202, 413, 8);
            dismantledFlowMeterSerialNumber.close();
            flowMeterRow_1b.close();

            PDPageContentStream flowMeterRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterProductionYear = textWriter.textWriterPDF(flowMeterRow_1c, fields.flowMeterDismantledProductionYear(), 341, 413, 8);
            dismantledFlowMeterProductionYear.close();
            flowMeterRow_1c.close();

            PDPageContentStream flowMeterRow_1d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterQn = textWriter.textWriterPDF(flowMeterRow_1d, fields.flowMeterDismantledQN(), 397, 413, 8);
            dismantledFlowMeterQn.close();
            flowMeterRow_1d.close();

            PDPageContentStream flowMeterRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterDN = textWriter.textWriterPDF(flowMeterRow_1e, fields.flowMeterDismantledDN(), 434, 413, 8);
            dismantledFlowMeterDN.close();
            flowMeterRow_1e.close();

            PDPageContentStream flowMeterRow_1f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterImpulse = textWriter.textWriterPDF(flowMeterRow_1f, fields.flowMeterDismantledImpulse(), 470, 413, 8);
            dismantledFlowMeterImpulse.close();
            flowMeterRow_1f.close();

            PDPageContentStream flowMeterRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterType = textWriter.textWriterPDF(flowMeterRow_2a, fields.flowMeterInstalled(), 130, 435, 8);
            installedFlowMeterType.close();
            flowMeterRow_2a.close();

            PDPageContentStream flowMeterRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterSerialNumber = textWriter.textWriterPDF(flowMeterRow_2b, fields.flowMeterInstalledSerialNumber(), 202, 435, 8);
            installedFlowMeterSerialNumber.close();
            flowMeterRow_2b.close();

            PDPageContentStream flowMeterRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterProductionYear = textWriter.textWriterPDF(flowMeterRow_2c, fields.flowMeterInstalledProductionYear(), 341, 435, 8);
            installedFlowMeterProductionYear.close();
            flowMeterRow_2c.close();

            PDPageContentStream flowMeterRow_2d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterQn = textWriter.textWriterPDF(flowMeterRow_2d, fields.flowMeterInstalledQN(), 397, 435, 8);
            installedFlowMeterQn.close();
            flowMeterRow_2d.close();

            PDPageContentStream flowMeterRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterDN = textWriter.textWriterPDF(flowMeterRow_2e, fields.flowMeterInstalledDN(), 434, 435, 8);
            installedFlowMeterDN.close();
            flowMeterRow_2e.close();

            PDPageContentStream flowMeterRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterImpulse = textWriter.textWriterPDF(flowMeterRow_2f, fields.flowMeterInstalledImpulse(), 470, 435, 8);
            installedFlowMeterImpulse.close();
            flowMeterRow_2f.close();

            PDPageContentStream flowMeterRow_2g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterLegalizationDate1 = textWriter.textWriterPDF(flowMeterRow_2g, fields.flowMeterInstalledLegalizationDate1(), 515, 435, 8);
            installedFlowMeterLegalizationDate1.close();
            flowMeterRow_2g.close();

            PDPageContentStream flowMeterRow_2h = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterLegalizationDate2 = textWriter.textWriterPDF(flowMeterRow_2h, "-" + fields.flowMeterInstalledLegalizationDate2(), 535, 435, 8);
            installedFlowMeterLegalizationDate2.close();
            flowMeterRow_2h.close();

            PDPageContentStream tempSensorRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorPT = textWriter.textWriterPDF(tempSensorRow_1a, fields.tempSensorDismantledPT(), 200, 503, 8);
            dismantledTempSensorPT.close();
            tempSensorRow_1a.close();

            PDPageContentStream tempSensorRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorType = textWriter.textWriterPDF(tempSensorRow_1b, fields.tempSensorDismantledType(), 245, 503, 8);
            dismantledTempSensorType.close();
            tempSensorRow_1b.close();

            PDPageContentStream tempSensorRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorSerialNumber1;
            PDPageContentStream dismantledTempSensorSerialNumber2;
            if (!fields.tempSensorDismantledSerialNumber1().isEmpty()) {
                dismantledTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1() + "/1", 335, 492, 8);
                dismantledTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1() + "/2", 335, 511, 8);
            } else {
                dismantledTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1(), 335, 492, 8);
                dismantledTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1(), 335, 511, 8);
            }
            dismantledTempSensorSerialNumber1.close();
            dismantledTempSensorSerialNumber2.close();
            tempSensorRow_1c.close();

            PDPageContentStream tempSensorRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorProductionYear = textWriter.textWriterPDF(tempSensorRow_1e, fields.tempSensorDismantledProductionYear(), 450, 503, 8);
            dismantledTempSensorProductionYear.close();
            tempSensorRow_1e.close();

            PDPageContentStream tempSensorRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorPT = textWriter.textWriterPDF(tempSensorRow_2a, fields.tempSensorInstalledPT(), 200, 540, 8);
            installedTempSensorPT.close();
            tempSensorRow_2a.close();

            PDPageContentStream tempSensorRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorType2 = textWriter.textWriterPDF(tempSensorRow_2b, fields.tempSensorInstalledType(), 245, 540, 8);
            installedTempSensorType2.close();
            tempSensorRow_2b.close();

            PDPageContentStream tempSensorRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorSerialNumber1;
            PDPageContentStream installedTempSensorSerialNumber2;
            if (!fields.tempSensorInstalledSerialNumber1().isEmpty()) {
                installedTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1() + "/1", 335, 529, 8);
                installedTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1() + "/2", 335, 547, 8);

            } else {
                installedTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1(), 335, 529, 8);
                installedTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1(), 335, 547, 8);
            }
            installedTempSensorSerialNumber1.close();
            installedTempSensorSerialNumber2.close();
            tempSensorRow_2c.close();

            PDPageContentStream tempSensorRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorProductionYear = textWriter.textWriterPDF(tempSensorRow_2e, fields.tempSensorInstalledProductionYear(), 450, 540, 8);
            installedTempSensorProductionYear.close();
            tempSensorRow_2e.close();

            PDPageContentStream tempSensorRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorLegalizationDate1 = textWriter.textWriterPDF(tempSensorRow_2f, fields.tempSensorInstalledLegalizationDate1(), 515, 540, 8);
            installedTempSensorLegalizationDate1.close();
            tempSensorRow_2f.close();

            PDPageContentStream tempSensorRow_2g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorLegalizationDate2 = textWriter.textWriterPDF(tempSensorRow_2g, "-" + fields.tempSensorInstalledLegalizationDate2(), 535, 540, 8);
            installedTempSensorLegalizationDate2.close();
            tempSensorRow_2g.close();

            PDPageContentStream otherField = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream otherServiceActions = textWriter.textWriterPDF(otherField, fields.otherActionsService(), 92, 586, 8);
            otherServiceActions.close();
            otherField.close();

            PDPageContentStream readingsAfterService1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream energyReadingsAfter = textWriter.textWriterPDF(readingsAfterService1, fields.energyAfter(), 174, 643, 8);
            energyReadingsAfter.close();
            readingsAfterService1.close();
            PDPageContentStream readingsAfterService2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream waterReadingsAfter = textWriter.textWriterPDF(readingsAfterService2, fields.waterAfter(), 291, 643, 8);
            waterReadingsAfter.close();
            readingsAfterService2.close();
            PDPageContentStream readingsAfterService3 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream flowConverterReadingsAfter = textWriter.textWriterPDF(readingsAfterService3, fields.flowConverterAfter(), 469, 643, 8);
            flowConverterReadingsAfter.close();
            readingsAfterService3.close();

            PDPageContentStream dateLine2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dateField2 = textWriter.textWriterPDF(dateLine2, fields.date(), 426, 685, 8);
            dateField2.close();
            dateLine2.close();

            PdfFileInfo fileInfo = pdfSaver.savePdf(pdfFile, fields.address(), fileConfiguration.savePath());
            pdfFile.close();
            return fileInfo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFromRadioButton1(final String actionType1, final PDDocument pdfFile, final PDPage firstPage, final TextWriter textWriter) throws IOException {
        PDPageContentStream action1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        switch (actionType1) {
            case "change" -> {
                PDPageContentStream change = textWriter.textWriterPDF(action1, "X", 150.5f, 153.5f, 18);
                change.close();
            }
            case "restoration" -> {
                PDPageContentStream restoration = textWriter.textWriterPDF(action1, "X", 386.5f, 153.5f, 18);
                restoration.close();
            }
            case "legalization" -> {
                PDPageContentStream legalization = textWriter.textWriterPDF(action1, "X", 538.5f, 153.5f, 18);
                legalization.close();
            }
            default -> System.out.println("Action type not found");
        }
        action1.close();
    }

    private void writeFromRadioButton2(final String actionType2, final PDDocument pdfFile, final PDPage firstPage, final TextWriter textWriter) throws IOException {
        PDPageContentStream action2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        switch (actionType2) {
            case "local" -> {
                PDPageContentStream local = textWriter.textWriterPDF(action2, "X", 243.5f, 176.5f, 18);
                local.close();
            }
            case "radio" -> {
                PDPageContentStream radio = textWriter.textWriterPDF(action2, "X", 351.5f, 176.5f, 18);
                radio.close();
            }
            case "auto" -> {
                PDPageContentStream auto = textWriter.textWriterPDF(action2, "X", 465.5f, 176.5f, 18);
                auto.close();
            }
            default -> System.out.println("Action type not found");
        }
        action2.close();
    }

    private PDDocument readTemplatePdf() {
        File oldFile = new File(fileConfiguration.readPath() + "PDF.pdf");
        PDDocument pdfFile = null;
        try {
            pdfFile = PDDocument.load(oldFile);
        } catch (Exception exception) {
            System.out.println("File not found");
        }
        assert pdfFile != null : "File is empty";
        return pdfFile;
    }


}
