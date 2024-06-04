package reports.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reports.interfaces.ReportPersister;
import reports.model.Report;
import reports.model.TrafficData;
import reports.util.ReportMapper;
import reports.util.ReportMapperJSON;
import reports.util.TestUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultReportPersisterJSONTest {

    ReportPersister reportPersister;
    ReportMapper reportMapper;

    @BeforeEach
    public void init() {
        reportMapper = new ReportMapperJSON();
        reportPersister = new DefaultReportPersister(reportMapper);
    }

    @Test
    public void testSaveReport1() throws IOException {

        String expected = TestUtils.readTextResource("expected/ipaddr1.json").get(0);

        Report sample = new Report(List.of(
                new TrafficData(
                        "150.23.122.180",
                        2,
                        1.0,
                        250,
                        1.0
                )));

        try (StringWriter writer = new StringWriter()) {
            reportPersister.saveReport(sample, writer);
            assertEquals(expected, writer.getBuffer().toString());
        }
    }
}
