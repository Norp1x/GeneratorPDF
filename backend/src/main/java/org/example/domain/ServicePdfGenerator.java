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

    // Address & date coordinates + font size
    private static final int ADDRESS_AND_DATE_FONT_SIZE = 9;
    private static final int FONT_SIZE = 7;

    private static final int ADDRESS_LINE_X = 142;
    private static final int ADDRESS_LINE_Y = 205;
    
    private static final int DATE_LINE_1_X = 146;
    private static final int DATE_LINE_1_Y = 230;

    private static final int DATE_LINE_2_X = 440;
    private static final int DATE_LINE_2_Y = 685;

    // Y_Coordinates section
    private static final int READINGS_BEFORE_Y = 276;
    private static final int DISMANTLED_METER_Y = 333;
    private static final int INSTALLED_METER_Y = 354;
    private static final int DISMANTLED_FLOW_METER_Y = 413;
    private static final int INSTALLED_FLOW_METER_Y = 435;
    private static final int DISMANTLED_TEMP_SENSOR_Y = 503;
    private static final int DISMANTLED_TEMP_SENSOR_SN_Y1 = 492;
    private static final int DISMANTLED_TEMP_SENSOR_SN_Y2 = 511;
    private static final int INSTALLED_TEMP_SENSOR_Y = 540;
    private static final int INSTALLED_TEMP_SENSOR_SN_Y1 = 529;
    private static final int INSTALLED_TEMP_SENSOR_SN_Y2 = 547;
    private static final int READINGS_AFTER_Y = 643;
    private static final int OTHER_ACTIONS_FIELD_Y = 586;

    // X_Coordinates section
    private static final int ENERGY_READINGS_COLUMN_X = 174;
    private static final int WATER_READINGS_COLUMN_X = 291;
    private static final int METER_TYPE_COLUMN_X = 130;
    private static final int METERS_SN_COLUMN_X = 212;
    private static final int METERS_PROD_YEAR_COLUMN_X = 348;
    private static final int RADIO_ADDR_AND_QN_COLUMN_X = 397;
    private static final int DN_COLUMN_X = 435;
    private static final int IMP_AND_FLOW_READINGS_COLUMN_X = 473;
    private static final int TEMP_SENSOR_PT_COLUMN_X = 208;
    private static final int TEMP_SENSOR_TYPE_COLUMN_X = 245;
    private static final int TEMP_SENSOR_SN_COLUMN_X = 342;
    private static final int TEMP_SENSOR_PROD_YEAR_COLUMN_X = 460;
    private static final int LEGALIZATION_DATE_COLUMN_X1 = 514;
    private static final int LEGALIZATION_DATE_COLUMN_X2 = 535;
    private static final int OTHER_ACTIONS_FIELD_X = 92;

    public PdfFileInfo generatePDF(Fields fields) {
        PDDocument pdfFile = null;
        try { pdfFile = readTemplatePdf();
            PDPage firstPage = pdfFile.getPage(0);
            TextWriter textWriter = new TextWriter(fileConfiguration.fontPath());

            writeFromRadioButton1(fields.actionType1(), pdfFile, firstPage, textWriter);
            writeFromRadioButton2(fields.actionType2(), pdfFile, firstPage, textWriter);

            PDPageContentStream addressLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream addressField = textWriter.textWriterPDF(addressLine, fields.address(), ADDRESS_LINE_X, ADDRESS_LINE_Y, ADDRESS_AND_DATE_FONT_SIZE);
            addressField.close();
            addressLine.close();

            PDPageContentStream dateLine = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dateField = textWriter.textWriterPDF(dateLine, fields.date(), DATE_LINE_1_X, DATE_LINE_1_Y, ADDRESS_AND_DATE_FONT_SIZE);
            dateField.close();
            dateLine.close();

            PDPageContentStream readingsBeforeService1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream energyReadingsBefore = textWriter.textWriterPDF(readingsBeforeService1, fields.energyBefore(), ENERGY_READINGS_COLUMN_X, READINGS_BEFORE_Y, FONT_SIZE);
            energyReadingsBefore.close();
            readingsBeforeService1.close();
            PDPageContentStream readingsBeforeService2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream waterReadingsBefore = textWriter.textWriterPDF(readingsBeforeService2, fields.waterBefore(), WATER_READINGS_COLUMN_X, READINGS_BEFORE_Y, FONT_SIZE);
            waterReadingsBefore.close();
            readingsBeforeService2.close();
            PDPageContentStream readingsBeforeService3 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream flowConverterReadingsBefore = textWriter.textWriterPDF(readingsBeforeService3, fields.flowConverterBefore(), IMP_AND_FLOW_READINGS_COLUMN_X, READINGS_BEFORE_Y, FONT_SIZE);
            flowConverterReadingsBefore.close();
            readingsBeforeService3.close();

            PDPageContentStream meterRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterType = textWriter.textWriterPDF(meterRow_1a, fields.meterDismantled(), METER_TYPE_COLUMN_X, DISMANTLED_METER_Y, FONT_SIZE);
            dismantledMeterType.close();
            meterRow_1a.close();

            PDPageContentStream meterRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterSerialNumber = textWriter.textWriterPDF(meterRow_1b, fields.meterDismantledSerialNumber(), METERS_SN_COLUMN_X, DISMANTLED_METER_Y, FONT_SIZE);
            dismantledMeterSerialNumber.close();
            meterRow_1b.close();

            PDPageContentStream meterRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterProductionYear = textWriter.textWriterPDF(meterRow_1c, fields.meterDismantledProductionYear(), METERS_PROD_YEAR_COLUMN_X, DISMANTLED_METER_Y, FONT_SIZE);
            dismantledMeterProductionYear.close();
            meterRow_1c.close();

            PDPageContentStream meterRow_1d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledRadioAddress = textWriter.textWriterPDF(meterRow_1d, fields.meterDismantledRadioAddress(), RADIO_ADDR_AND_QN_COLUMN_X, DISMANTLED_METER_Y, FONT_SIZE);
            dismantledRadioAddress.close();
            meterRow_1d.close();

            PDPageContentStream meterRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterImpulse = textWriter.textWriterPDF(meterRow_1e, fields.meterDismantledImpulse(), IMP_AND_FLOW_READINGS_COLUMN_X, DISMANTLED_METER_Y, FONT_SIZE);
            dismantledMeterImpulse.close();
            meterRow_1e.close();

            PDPageContentStream meterRow_1f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterLegalizationDate1 = textWriter.textWriterPDF(meterRow_1f, fields.meterDismantledLegalizationDate1(), LEGALIZATION_DATE_COLUMN_X1, DISMANTLED_METER_Y, FONT_SIZE);
            dismantledMeterLegalizationDate1.close();
            meterRow_1f.close();

            PDPageContentStream meterRow_1g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledMeterLegalizationDate2 = textWriter.textWriterPDF(meterRow_1g, "-" + fields.meterDismantledLegalizationDate2(), LEGALIZATION_DATE_COLUMN_X2, DISMANTLED_METER_Y, FONT_SIZE);
            dismantledMeterLegalizationDate2.close();
            meterRow_1g.close();

            PDPageContentStream meterRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterType = textWriter.textWriterPDF(meterRow_2a, fields.meterInstalled(), METER_TYPE_COLUMN_X, INSTALLED_METER_Y, FONT_SIZE);
            installedMeterType.close();
            meterRow_2a.close();

            PDPageContentStream meterRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterSerialNumber = textWriter.textWriterPDF(meterRow_2b, fields.meterInstalledSerialNumber(), METERS_SN_COLUMN_X, INSTALLED_METER_Y, FONT_SIZE);
            installedMeterSerialNumber.close();
            meterRow_2b.close();

            PDPageContentStream meterRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterProductionYear = textWriter.textWriterPDF(meterRow_2c, fields.meterInstalledProductionYear(), METERS_PROD_YEAR_COLUMN_X, INSTALLED_METER_Y, FONT_SIZE);
            installedMeterProductionYear.close();
            meterRow_2c.close();

            PDPageContentStream meterRow_2d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterRadioAddress = textWriter.textWriterPDF(meterRow_2d, fields.meterInstalledRadioAddress(), RADIO_ADDR_AND_QN_COLUMN_X, INSTALLED_METER_Y, FONT_SIZE);
            installedMeterRadioAddress.close();
            meterRow_2d.close();

            PDPageContentStream meterRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterImpulse = textWriter.textWriterPDF(meterRow_2e, fields.meterInstalledImpulse(), IMP_AND_FLOW_READINGS_COLUMN_X, INSTALLED_METER_Y, FONT_SIZE);
            installedMeterImpulse.close();
            meterRow_2e.close();

            PDPageContentStream meterRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterLegalizationDate1 = textWriter.textWriterPDF(meterRow_2f, fields.meterInstalledLegalizationDate1(), LEGALIZATION_DATE_COLUMN_X1, INSTALLED_METER_Y, FONT_SIZE);
            installedMeterLegalizationDate1.close();
            meterRow_2f.close();

            PDPageContentStream meterRow_2g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedMeterLegalizationDate2 = textWriter.textWriterPDF(meterRow_2g, "-" + fields.meterInstalledLegalizationDate2(), LEGALIZATION_DATE_COLUMN_X2, INSTALLED_METER_Y, FONT_SIZE);
            installedMeterLegalizationDate2.close();
            meterRow_2g.close();

            PDPageContentStream flowMeterRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterType = textWriter.textWriterPDF(flowMeterRow_1a, fields.flowMeterDismantled(), METER_TYPE_COLUMN_X, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterType.close();
            flowMeterRow_1a.close();

            PDPageContentStream flowMeterRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterSerialNumber = textWriter.textWriterPDF(flowMeterRow_1b, fields.flowMeterDismantledSerialNumber(), METERS_SN_COLUMN_X, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterSerialNumber.close();
            flowMeterRow_1b.close();

            PDPageContentStream flowMeterRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterProductionYear = textWriter.textWriterPDF(flowMeterRow_1c, fields.flowMeterDismantledProductionYear(), METERS_PROD_YEAR_COLUMN_X, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterProductionYear.close();
            flowMeterRow_1c.close();

            PDPageContentStream flowMeterRow_1d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterQn = textWriter.textWriterPDF(flowMeterRow_1d, fields.flowMeterDismantledQN(), RADIO_ADDR_AND_QN_COLUMN_X, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterQn.close();
            flowMeterRow_1d.close();

            PDPageContentStream flowMeterRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterDN = textWriter.textWriterPDF(flowMeterRow_1e, fields.flowMeterDismantledDN(), DN_COLUMN_X, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterDN.close();
            flowMeterRow_1e.close();

            PDPageContentStream flowMeterRow_1f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterImpulse = textWriter.textWriterPDF(flowMeterRow_1f, fields.flowMeterDismantledImpulse(), IMP_AND_FLOW_READINGS_COLUMN_X, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterImpulse.close();
            flowMeterRow_1f.close();

            PDPageContentStream flowMeterRow_1g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterLegalizationDate1 = textWriter.textWriterPDF(flowMeterRow_1g, fields.flowMeterDismantledLegalizationDate1(), LEGALIZATION_DATE_COLUMN_X1, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterLegalizationDate1.close();
            flowMeterRow_1g.close();

            PDPageContentStream flowMeterRow_1h = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledFlowMeterLegalizationDate2 = textWriter.textWriterPDF(flowMeterRow_1h, "-" + fields.flowMeterDismantledLegalizationDate2(), LEGALIZATION_DATE_COLUMN_X2, DISMANTLED_FLOW_METER_Y, FONT_SIZE);
            dismantledFlowMeterLegalizationDate2.close();
            flowMeterRow_1h.close();

            PDPageContentStream flowMeterRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterType = textWriter.textWriterPDF(flowMeterRow_2a, fields.flowMeterInstalled(), METER_TYPE_COLUMN_X, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterType.close();
            flowMeterRow_2a.close();

            PDPageContentStream flowMeterRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterSerialNumber = textWriter.textWriterPDF(flowMeterRow_2b, fields.flowMeterInstalledSerialNumber(), METERS_SN_COLUMN_X, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterSerialNumber.close();
            flowMeterRow_2b.close();

            PDPageContentStream flowMeterRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterProductionYear = textWriter.textWriterPDF(flowMeterRow_2c, fields.flowMeterInstalledProductionYear(), METERS_PROD_YEAR_COLUMN_X, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterProductionYear.close();
            flowMeterRow_2c.close();

            PDPageContentStream flowMeterRow_2d = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterQn = textWriter.textWriterPDF(flowMeterRow_2d, fields.flowMeterInstalledQN(), RADIO_ADDR_AND_QN_COLUMN_X, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterQn.close();
            flowMeterRow_2d.close();

            PDPageContentStream flowMeterRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterDN = textWriter.textWriterPDF(flowMeterRow_2e, fields.flowMeterInstalledDN(), DN_COLUMN_X, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterDN.close();
            flowMeterRow_2e.close();

            PDPageContentStream flowMeterRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterImpulse = textWriter.textWriterPDF(flowMeterRow_2f, fields.flowMeterInstalledImpulse(), IMP_AND_FLOW_READINGS_COLUMN_X, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterImpulse.close();
            flowMeterRow_2f.close();

            PDPageContentStream flowMeterRow_2g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterLegalizationDate1 = textWriter.textWriterPDF(flowMeterRow_2g, fields.flowMeterInstalledLegalizationDate1(), LEGALIZATION_DATE_COLUMN_X1, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterLegalizationDate1.close();
            flowMeterRow_2g.close();

            PDPageContentStream flowMeterRow_2h = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedFlowMeterLegalizationDate2 = textWriter.textWriterPDF(flowMeterRow_2h, "-" + fields.flowMeterInstalledLegalizationDate2(), LEGALIZATION_DATE_COLUMN_X2, INSTALLED_FLOW_METER_Y, FONT_SIZE);
            installedFlowMeterLegalizationDate2.close();
            flowMeterRow_2h.close();

            PDPageContentStream tempSensorRow_1a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorPT = textWriter.textWriterPDF(tempSensorRow_1a, fields.tempSensorDismantledPT(), TEMP_SENSOR_PT_COLUMN_X, DISMANTLED_TEMP_SENSOR_Y, FONT_SIZE);
            dismantledTempSensorPT.close();
            tempSensorRow_1a.close();

            PDPageContentStream tempSensorRow_1b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorType = textWriter.textWriterPDF(tempSensorRow_1b, fields.tempSensorDismantledType(), TEMP_SENSOR_TYPE_COLUMN_X, DISMANTLED_TEMP_SENSOR_Y, FONT_SIZE);
            dismantledTempSensorType.close();
            tempSensorRow_1b.close();

            PDPageContentStream tempSensorRow_1c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorSerialNumber1;
            PDPageContentStream dismantledTempSensorSerialNumber2;
            if (!fields.tempSensorDismantledSerialNumber1().isEmpty()) {
                dismantledTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1() + "/1", TEMP_SENSOR_SN_COLUMN_X, DISMANTLED_TEMP_SENSOR_SN_Y1, FONT_SIZE);
                dismantledTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1() + "/2", TEMP_SENSOR_SN_COLUMN_X, DISMANTLED_TEMP_SENSOR_SN_Y2, FONT_SIZE);
            } else {
                dismantledTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1(), TEMP_SENSOR_SN_COLUMN_X, DISMANTLED_TEMP_SENSOR_SN_Y1, FONT_SIZE);
                dismantledTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_1c, fields.tempSensorDismantledSerialNumber1(), TEMP_SENSOR_SN_COLUMN_X, DISMANTLED_TEMP_SENSOR_SN_Y2, FONT_SIZE);
            }
            dismantledTempSensorSerialNumber1.close();
            dismantledTempSensorSerialNumber2.close();
            tempSensorRow_1c.close();

            PDPageContentStream tempSensorRow_1e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorProductionYear = textWriter.textWriterPDF(tempSensorRow_1e, fields.tempSensorDismantledProductionYear(), TEMP_SENSOR_PROD_YEAR_COLUMN_X, DISMANTLED_TEMP_SENSOR_Y, FONT_SIZE);
            dismantledTempSensorProductionYear.close();
            tempSensorRow_1e.close();

            PDPageContentStream tempSensorRow_1f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorLegalizationDate1 = textWriter.textWriterPDF(tempSensorRow_1f, fields.tempSensorDismantledLegalizationDate1(), LEGALIZATION_DATE_COLUMN_X1, DISMANTLED_TEMP_SENSOR_Y, FONT_SIZE);
            dismantledTempSensorLegalizationDate1.close();
            tempSensorRow_1f.close();

            PDPageContentStream tempSensorRow_1g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dismantledTempSensorLegalizationDate2 = textWriter.textWriterPDF(tempSensorRow_1g, "-" + fields.tempSensorDismantledLegalizationDate2(), LEGALIZATION_DATE_COLUMN_X2, DISMANTLED_TEMP_SENSOR_Y, FONT_SIZE);
            dismantledTempSensorLegalizationDate2.close();
            tempSensorRow_1g.close();

            PDPageContentStream tempSensorRow_2a = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorPT = textWriter.textWriterPDF(tempSensorRow_2a, fields.tempSensorInstalledPT(), TEMP_SENSOR_PT_COLUMN_X, INSTALLED_TEMP_SENSOR_Y, FONT_SIZE);
            installedTempSensorPT.close();
            tempSensorRow_2a.close();

            PDPageContentStream tempSensorRow_2b = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorType2 = textWriter.textWriterPDF(tempSensorRow_2b, fields.tempSensorInstalledType(), TEMP_SENSOR_TYPE_COLUMN_X, INSTALLED_TEMP_SENSOR_Y, FONT_SIZE);
            installedTempSensorType2.close();
            tempSensorRow_2b.close();

            PDPageContentStream tempSensorRow_2c = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorSerialNumber1;
            PDPageContentStream installedTempSensorSerialNumber2;
            if (!fields.tempSensorInstalledSerialNumber1().isEmpty()) {
                installedTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1() + "/1", TEMP_SENSOR_SN_COLUMN_X, INSTALLED_TEMP_SENSOR_SN_Y1, FONT_SIZE);
                installedTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1() + "/2", TEMP_SENSOR_SN_COLUMN_X, INSTALLED_TEMP_SENSOR_SN_Y2, FONT_SIZE);

            } else {
                installedTempSensorSerialNumber1 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1(), TEMP_SENSOR_SN_COLUMN_X, INSTALLED_TEMP_SENSOR_SN_Y1, FONT_SIZE);
                installedTempSensorSerialNumber2 = textWriter.textWriterPDF(tempSensorRow_2c, fields.tempSensorInstalledSerialNumber1(), TEMP_SENSOR_SN_COLUMN_X, INSTALLED_TEMP_SENSOR_SN_Y2, FONT_SIZE);
            }
            installedTempSensorSerialNumber1.close();
            installedTempSensorSerialNumber2.close();
            tempSensorRow_2c.close();

            PDPageContentStream tempSensorRow_2e = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorProductionYear = textWriter.textWriterPDF(tempSensorRow_2e, fields.tempSensorInstalledProductionYear(), TEMP_SENSOR_PROD_YEAR_COLUMN_X, INSTALLED_TEMP_SENSOR_Y, FONT_SIZE);
            installedTempSensorProductionYear.close();
            tempSensorRow_2e.close();

            PDPageContentStream tempSensorRow_2f = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorLegalizationDate1 = textWriter.textWriterPDF(tempSensorRow_2f, fields.tempSensorInstalledLegalizationDate1(), LEGALIZATION_DATE_COLUMN_X1, INSTALLED_TEMP_SENSOR_Y, FONT_SIZE);
            installedTempSensorLegalizationDate1.close();
            tempSensorRow_2f.close();

            PDPageContentStream tempSensorRow_2g = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream installedTempSensorLegalizationDate2 = textWriter.textWriterPDF(tempSensorRow_2g, "-" + fields.tempSensorInstalledLegalizationDate2(), LEGALIZATION_DATE_COLUMN_X2, INSTALLED_TEMP_SENSOR_Y, FONT_SIZE);
            installedTempSensorLegalizationDate2.close();
            tempSensorRow_2g.close();

            PDPageContentStream otherField = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream otherServiceActions = textWriter.textWriterPDF(otherField, fields.otherActionsService(), OTHER_ACTIONS_FIELD_X, OTHER_ACTIONS_FIELD_Y, FONT_SIZE);
            otherServiceActions.close();
            otherField.close();

            PDPageContentStream readingsAfterService1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);

            PDPageContentStream energyReadingsAfter = textWriter.textWriterPDF(readingsAfterService1, fields.energyAfter(), ENERGY_READINGS_COLUMN_X, READINGS_AFTER_Y, FONT_SIZE);
            energyReadingsAfter.close();
            readingsAfterService1.close();
            PDPageContentStream readingsAfterService2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream waterReadingsAfter = textWriter.textWriterPDF(readingsAfterService2, fields.waterAfter(), WATER_READINGS_COLUMN_X, READINGS_AFTER_Y, FONT_SIZE);
            waterReadingsAfter.close();
            readingsAfterService2.close();
            PDPageContentStream readingsAfterService3 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream flowConverterReadingsAfter = textWriter.textWriterPDF(readingsAfterService3, fields.flowConverterAfter(), IMP_AND_FLOW_READINGS_COLUMN_X, READINGS_AFTER_Y, FONT_SIZE);
            flowConverterReadingsAfter.close();
            readingsAfterService3.close();

            PDPageContentStream dateLine2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
            PDPageContentStream dateField2 = textWriter.textWriterPDF(dateLine2, fields.date(), DATE_LINE_2_X, DATE_LINE_2_Y, ADDRESS_AND_DATE_FONT_SIZE);
            dateField2.close();
            dateLine2.close();

            PdfFileInfo fileInfo = pdfSaver.savePdf(pdfFile, fields.address(), fileConfiguration.savePath());
            pdfFile.close();
            return fileInfo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (pdfFile != null) {
                try {
                    pdfFile.close();
                } catch (IOException e) {
                    throw new RuntimeException("Error closing PDF file", e);
                }
            }
        }
    }

    private void writeFromRadioButton1(final String actionType1, final PDDocument pdfFile, final PDPage firstPage, final TextWriter textWriter) throws IOException {
        PDPageContentStream action1 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        final float ACTION_TYPE_Y = 153.5f;
        final int fontSize = 18;
        switch (actionType1) {
            case "change" -> {
                PDPageContentStream change = textWriter.textWriterPDF(action1, "X", 150.5f, ACTION_TYPE_Y, fontSize);
                change.close();
            }
            case "restoration" -> {
                PDPageContentStream restoration = textWriter.textWriterPDF(action1, "X", 386.5f, ACTION_TYPE_Y, fontSize);
                restoration.close();
            }
            case "legalization" -> {
                PDPageContentStream legalization = textWriter.textWriterPDF(action1, "X", 538.5f, ACTION_TYPE_Y, fontSize);
                legalization.close();
            }
            default -> System.out.println("Action type not found");
        }
        action1.close();
    }

    private void writeFromRadioButton2(final String actionType2, final PDDocument pdfFile, final PDPage firstPage, final TextWriter textWriter) throws IOException {
        PDPageContentStream action2 = new PDPageContentStream(pdfFile, firstPage, PDPageContentStream.AppendMode.APPEND, true, true);
        final float READING_TYPE_Y = 176.5f;
        final int fontSize = 18;
        switch (actionType2) {
            case "local" -> {
                PDPageContentStream local = textWriter.textWriterPDF(action2, "X", 243.5f, READING_TYPE_Y, fontSize);
                local.close();
            }
            case "radio" -> {
                PDPageContentStream radio = textWriter.textWriterPDF(action2, "X", 351.5f, READING_TYPE_Y, fontSize);
                radio.close();
            }
            case "auto" -> {
                PDPageContentStream auto = textWriter.textWriterPDF(action2, "X", 465.5f, READING_TYPE_Y, fontSize);
                auto.close();
            }
            default -> System.out.println("Action type not found");
        }
        action2.close();
    }

    private PDDocument readTemplatePdf() throws IOException {
        File oldFile = new File(fileConfiguration.readPath() + "PDF.pdf");
        return PDDocument.load(oldFile);
    }


}
