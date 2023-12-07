package org.example;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@AllArgsConstructor
@EnableConfigurationProperties(FileConfiguration.class)
public class PdfGenerator {

//    @Value("${pdf.file.savepath}")
//    public final String savePath;
//    // "/home/ec2-user/static/"
//    @Value("${pdf.file.path}")
//    public final String readFilePath;
//
//    @Value("${pdf.font.path}")
//    public final String fontFilePath;

    private final FileConfiguration fileConfiguration;

    private final PdfSaver pdfSaver = new PdfSaver();

    // "/home/ec2-user/static/"

    public PDPageContentStream writeMeterDismantledType(String meterDismantled, PDPageContentStream meterRow_1a, TextWriter textWriter) throws IOException {
        PDPageContentStream meterDismantledTypeStream;
        if (meterDismantled.equalsIgnoreCase("Multical 603") || meterDismantled.equalsIgnoreCase("Multical 403")
                || meterDismantled.equalsIgnoreCase("SCYLAR 548")) {
            meterDismantledTypeStream = textWriter.textWriterPDF(meterRow_1a, meterDismantled, 129, 333, 8.5f);
        } else {
            meterDismantledTypeStream = textWriter.textWriterPDF(meterRow_1a, meterDismantled, 135, 332, 13);
        }
        return meterDismantledTypeStream;
    }

    public PDPageContentStream writeMeterInstalledType(String meterDismantled, PDPageContentStream meterRow_2a, TextWriter textWriter) throws IOException {
        PDPageContentStream meterInstalledTypeStream;
        if (meterDismantled.equalsIgnoreCase("Multical 603") || meterDismantled.equalsIgnoreCase("Multical 403")
                || meterDismantled.equalsIgnoreCase("SCYLAR 548")) {
            meterInstalledTypeStream = textWriter.textWriterPDF(meterRow_2a, meterDismantled, 129, 356, 8.5f);
        } else {
            meterInstalledTypeStream = textWriter.textWriterPDF(meterRow_2a, meterDismantled, 135, 357, 13);
        }
        return meterInstalledTypeStream;
    }

    public PDPageContentStream writeFlowMeterDismantledType(String flowMeterDismantled, PDPageContentStream flowMeterRow_1a, TextWriter textWriter) throws IOException {
        PDPageContentStream flowMeterDismantledTypeStream;
        if (flowMeterDismantled.equalsIgnoreCase("AXONIC") || flowMeterDismantled.equalsIgnoreCase("UNICO 2")) {
            flowMeterDismantledTypeStream = textWriter.textWriterPDF(flowMeterRow_1a, flowMeterDismantled, 130, 413, 13);
        } else {
            flowMeterDismantledTypeStream = textWriter.textWriterPDF(flowMeterRow_1a, flowMeterDismantled, 130, 413, 9);
        }
        return flowMeterDismantledTypeStream;
    }

    public PDPageContentStream writeFlowMeterInstalledType(String flowMeterInstalled, PDPageContentStream flowMeterRow_1a, TextWriter textWriter) throws IOException {
        PDPageContentStream flowMeterInstalledTypeStream;
        if (flowMeterInstalled.equalsIgnoreCase("AXONIC") || flowMeterInstalled.equalsIgnoreCase("UNICO 2")) {
            flowMeterInstalledTypeStream = textWriter.textWriterPDF(flowMeterRow_1a, flowMeterInstalled, 130, 437, 13);
        } else {
            flowMeterInstalledTypeStream = textWriter.textWriterPDF(flowMeterRow_1a, flowMeterInstalled, 130, 437, 9);
        }
        return flowMeterInstalledTypeStream;
    }

    PdfFileInfo generatePDF(Fields fields) throws IOException {
        PDDocument pdfFile = readTemplatePdf();
        PDPage firstPage = pdfFile.getPage(0);
        TextWriter textWriter = new TextWriter(fileConfiguration.fontPath());

        writeFromRadioButton(fields.actionType1(), pdfFile, firstPage, textWriter);
        writeFromRadioButton2(fields.actionType2(), pdfFile, firstPage, textWriter);

        PDPageContentStream addressLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream addressField = textWriter.textWriterPDF(addressLine, fields.address(), 142, 206, 19);
        addressField.close();
        addressLine.close();

        PDPageContentStream dateLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dateField = textWriter.textWriterPDF(dateLine, fields.date(), 142, 231, 19);
        dateField.close();
        dateLine.close();

        PDPageContentStream readingsBeforeService1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream energyReadingsBefore = textWriter.textWriterPDF(readingsBeforeService1, fields.energy(), 174, 276.7f, 13);
        energyReadingsBefore.close();
        readingsBeforeService1.close();
        PDPageContentStream readingsBeforeService2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream waterReadingsBefore = textWriter.textWriterPDF(readingsBeforeService2, fields.water(), 291, 276.7f, 13);
        waterReadingsBefore.close();
        readingsBeforeService2.close();
        PDPageContentStream readingsBeforeService3 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream flowConverterReadingsBefore = textWriter.textWriterPDF(readingsBeforeService3, fields.flowConverter(), 471, 276.7f, 13);
        flowConverterReadingsBefore.close();
        readingsBeforeService3.close();

        PDPageContentStream meterRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledMeterType = writeMeterDismantledType(fields.meterDismantled(), meterRow_1a, textWriter);
        dismantledMeterType.close();
        meterRow_1a.close();

        PDPageContentStream meterRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledMeterSerialNumber = textWriter.textWriterPDF(meterRow_1b, fields.meterDismantledSerialNumber(), 202, 333, 13);
        dismantledMeterSerialNumber.close();
        meterRow_1b.close();

        PDPageContentStream meterRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledMeterProductionYear = textWriter.textWriterPDF(meterRow_1c, fields.meterDismantledProductionYear(), 341, 333, 13);
        dismantledMeterProductionYear.close();
        meterRow_1c.close();

        PDPageContentStream meterRow_1d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledRadioAddress = textWriter.textWriterPDF(meterRow_1d, fields.meterDismantledRadioAddress(), 397, 333, 13);
        dismantledRadioAddress.close();
        meterRow_1d.close();

        PDPageContentStream meterRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledMeterImpulse = textWriter.textWriterPDF(meterRow_1e, fields.meterDismantledImpulse(), 470, 333, 13);
        dismantledMeterImpulse.close();
        meterRow_1e.close();

        PDPageContentStream meterRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedMeterType = writeMeterInstalledType(fields.meterInstalled(), meterRow_2a, textWriter);
        installedMeterType.close();
        meterRow_2a.close();

        PDPageContentStream meterRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedMeterSerialNumber = textWriter.textWriterPDF(meterRow_2b, fields.meterInstalledSerialNumber(), 202, 357, 13);
        installedMeterSerialNumber.close();
        meterRow_2b.close();

        PDPageContentStream meterRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedMeterProductionYear = textWriter.textWriterPDF(meterRow_2c, fields.meterInstalledProductionYear(), 341, 357, 13);
        installedMeterProductionYear.close();
        meterRow_2c.close();

        PDPageContentStream meterRow_2d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedMeterRadioAddress = textWriter.textWriterPDF(meterRow_2d, fields.meterInstalledRadioAddress(), 397, 357, 13);
        installedMeterRadioAddress.close();
        meterRow_2d.close();

        PDPageContentStream meterRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedMeterImpulse = textWriter.textWriterPDF(meterRow_2e, fields.meterInstalledImpulse(), 470, 357, 13);
        installedMeterImpulse.close();
        meterRow_2e.close();

        PDPageContentStream meterRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream legalizationDate = textWriter.textWriterPDF(meterRow_2f, fields.meterInstalledLegalizationDate(), 503.5f, 357, 13);
        legalizationDate.close();
        meterRow_2f.close();

        PDPageContentStream flowMeterRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledFlowMeterType = writeFlowMeterDismantledType("SONO", flowMeterRow_1a, textWriter);
        dismantledFlowMeterType.close();
        flowMeterRow_1a.close();

        PDPageContentStream flowMeterRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledFlowMeterSerialNumber = textWriter.textWriterPDF(flowMeterRow_1b, "1231451", 202, 413, 13);
        dismantledFlowMeterSerialNumber.close();
        flowMeterRow_1b.close();

        PDPageContentStream flowMeterRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledFlowMeterProductionYear = textWriter.textWriterPDF(flowMeterRow_1c, "2021", 341, 413, 13);
        dismantledFlowMeterProductionYear.close();
        flowMeterRow_1c.close();

        PDPageContentStream flowMeterRow_1d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledFlowMeterQn = textWriter.textWriterPDF(flowMeterRow_1d, "15", 397, 413, 13);
        dismantledFlowMeterQn.close();
        flowMeterRow_1d.close();

        PDPageContentStream flowMeterRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledFlowMeterDN = textWriter.textWriterPDF(flowMeterRow_1e, "15", 434, 413, 13);
        dismantledFlowMeterDN.close();
        flowMeterRow_1e.close();

        PDPageContentStream flowMeterRow_1f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledFlowMeterImpulse = textWriter.textWriterPDF(flowMeterRow_1f, "50", 470, 413, 13);
        dismantledFlowMeterImpulse.close();
        flowMeterRow_1f.close();

        PDPageContentStream flowMeterRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedFlowMeterType = writeFlowMeterInstalledType("SONO", flowMeterRow_2a, textWriter);
        installedFlowMeterType.close();
        flowMeterRow_2a.close();

        PDPageContentStream flowMeterRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream flowMeterInstalledSerialNumber = textWriter.textWriterPDF(flowMeterRow_2b, "123151", 202, 437, 13);
        flowMeterInstalledSerialNumber.close();
        flowMeterRow_2b.close();

        PDPageContentStream flowMeterRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream flowMeterInstalledProductionYear = textWriter.textWriterPDF(flowMeterRow_2c, "2021", 341, 437, 13);
        flowMeterInstalledProductionYear.close();
        flowMeterRow_2c.close();

        PDPageContentStream flowMeterRow_2d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedFlowMeterQn = textWriter.textWriterPDF(flowMeterRow_2d, "15", 397, 437, 13);
        installedFlowMeterQn.close();
        flowMeterRow_2d.close();

        PDPageContentStream flowMeterRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream flowMeterInstalledDN = textWriter.textWriterPDF(flowMeterRow_2e, "15", 434, 437, 13);
        flowMeterInstalledDN.close();
        flowMeterRow_2e.close();

        PDPageContentStream flowMeterRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream flowMeterInstalledImpulse = textWriter.textWriterPDF(flowMeterRow_2f, "50", 470, 437, 13);
        flowMeterInstalledImpulse.close();
        flowMeterRow_2f.close();

        PDPageContentStream flowMeterRow_2g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream legalizationDateFlowMeter = textWriter.textWriterPDF(flowMeterRow_2g, "2021-08", 503.5f, 437, 13);
        legalizationDateFlowMeter.close();
        flowMeterRow_2g.close();

        PDPageContentStream tempSensorRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledTempSensorPT = textWriter.textWriterPDF(tempSensorRow_1a, "500", 200, 503, 13);
        dismantledTempSensorPT.close();
        tempSensorRow_1a.close();

        PDPageContentStream tempSensorRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledTempSensorType = textWriter.textWriterPDF(tempSensorRow_1b, "TSH-202", 256, 503, 13);
        dismantledTempSensorType.close();
        tempSensorRow_1b.close();

        PDPageContentStream tempSensorRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_1c, "123456789", 335, 492, 11);
        dismantledTempSensorSerialNumber1.close();
        tempSensorRow_1c.close();

        PDPageContentStream tempSensorRow_1d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_1d, "123456789", 335, 511, 11);
        dismantledTempSensorSerialNumber2.close();
        tempSensorRow_1d.close();

        PDPageContentStream tempSensorRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream dismantledTempSensorProductionYear = textWriter.textWriterPDF(tempSensorRow_1e, "2021-08", 450, 503, 12);
        dismantledTempSensorProductionYear.close();
        tempSensorRow_1e.close();

        PDPageContentStream tempSensorRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedTempSensorPT2 = textWriter.textWriterPDF(tempSensorRow_2a, "500", 200, 540, 13);
        installedTempSensorPT2.close();
        tempSensorRow_2a.close();

        PDPageContentStream tempSensorRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedTempSensorType2 = textWriter.textWriterPDF(tempSensorRow_2b, "TSH-202", 256, 540, 13);
        installedTempSensorType2.close();
        tempSensorRow_2b.close();

        PDPageContentStream tempSensorRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_2c, "123456789", 335, 529, 11);
        installedTempSensorSerialNumber1.close();
        tempSensorRow_2c.close();

        PDPageContentStream tempSensorRow_2d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_2d, "123456789", 335, 547, 11);
        installedTempSensorSerialNumber2.close();
        tempSensorRow_2d.close();

        PDPageContentStream tempSensorRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream installedTempSensorProductionYear = textWriter.textWriterPDF(tempSensorRow_2e, "2021-08", 450, 540, 12);
        installedTempSensorProductionYear.close();
        tempSensorRow_2e.close();

        PDPageContentStream tempSensorRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream legalizationDateTempSensor = textWriter.textWriterPDF(tempSensorRow_2f, "2021-08", 503.5f, 540, 13);
        legalizationDateTempSensor.close();
        tempSensorRow_2f.close();

        PDPageContentStream otherField = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream otherServiceActions = textWriter.textWriterPDF(otherField, "Other Service actions written here", 92, 586, 13);
        otherServiceActions.close();
        otherField.close();

        PDPageContentStream readingsAfterService = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream energyReadingsAfter = textWriter.textWriterPDF(readingsAfterService, "energy", 174, 643, 13);
        energyReadingsAfter.close();
        readingsAfterService.close();
        PDPageContentStream readingsAfterService2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream waterReadingsAfter = textWriter.textWriterPDF(readingsAfterService2, "water", 291, 643, 13);
        waterReadingsAfter.close();
        readingsAfterService2.close();
        PDPageContentStream readingsAfterService3 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        PDPageContentStream flowConverterReadingsAfter = textWriter.textWriterPDF(readingsAfterService3, "flowConverter", 469, 643, 13);
        flowConverterReadingsAfter.close();
        readingsAfterService3.close();

        PdfFileInfo fileInfo = pdfSaver.savePdf(pdfFile, fields.address(), fileConfiguration.savePath());
        pdfFile.close();
        return fileInfo;
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

    private void writeFromRadioButton(final String actionType1, final PDDocument pdfFile, final PDPage firstPage, final TextWriter textWriter) throws IOException {
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
