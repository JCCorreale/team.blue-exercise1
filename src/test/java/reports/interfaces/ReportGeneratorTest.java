package reports.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reports.model.Report;
import reports.model.RequestLog;
import reports.util.ReportMapper;
import reports.util.RequestMapper;
import reports.util.TestUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportGeneratorTest {

    ReportGenerator reportGenerator;

    @BeforeEach
    public void init() {
        // TODO Initialize report generator
        reportGenerator = new DummyReportGenerator();
    }

    @Test
    public void testSample1() throws IOException {

        Report expected = new ReportMapper().parseReportCSV(
                TestUtils.readTextResource("expected/ipaddr1.csv"));

        RequestLog sample = new RequestMapper()
                .parseRequestLogCSV(TestUtils.readTextResource("samples/requests1.csv"));

        Report actual = reportGenerator.generateReport(sample);

        assertEquals(expected, actual);
    }
}
