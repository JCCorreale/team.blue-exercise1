package reports.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reports.interfaces.ReportGenerator;
import reports.model.Report;
import reports.model.RequestLog;
import reports.util.ReportMapperCSV;
import reports.util.RequestMapperCSV;
import reports.util.TestUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultReportGeneratorTest {

    ReportGenerator reportGenerator;

    @BeforeEach
    public void init() {
        reportGenerator = new DefaultReportGenerator();
    }

    private void testSample(String sampleResourcePath, String expectedResourcePath) throws IOException {
        Report expected = new ReportMapperCSV().parseReport(
                TestUtils.readTextResource(expectedResourcePath));

        RequestLog sample = new RequestMapperCSV()
                .parseRequestLogCSV(TestUtils.readTextResource(sampleResourcePath));

        Report actual = reportGenerator.generateReport(sample);

        assertEquals(expected, actual);
    }

    @Test
    public void testSample1() throws IOException {
        testSample("samples/requests1.csv", "expected/ipaddr1.csv");
    }

    @Test
    public void testSample2() throws IOException {
        testSample( "samples/requests2.csv", "expected/ipaddr2.csv");
    }
}
