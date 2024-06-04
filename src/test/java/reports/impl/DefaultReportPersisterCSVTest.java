package reports.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reports.interfaces.ReportPersister;
import reports.model.Report;
import reports.model.TrafficData;
import reports.util.ReportMapperCSV;
import reports.util.TestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultReportPersisterCSVTest {

    ReportPersister reportPersister;
    ReportMapperCSV reportMapper;

    @BeforeEach
    public void init() {
        reportMapper = new ReportMapperCSV();
        reportPersister = new DefaultReportPersister(reportMapper);
    }

    @Test
    public void testSaveReport1() throws IOException {

        List<String> expected = TestUtils.readTextResource("expected/ipaddr1.csv");

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
            assertEquals(expected, toLines(writer));
        }
    }

    @Test
    public void testSaveReport2() throws IOException {

        List<String> expected = TestUtils.readTextResource("expected/ipaddr2.csv");

        Report sample = new Report(List.of(
                new TrafficData("90.0.210.209", 3, 0.375, 300, 0.375),
                new TrafficData("150.23.122.180", 2, 0.25,200,0.25),
                new TrafficData("214.58.42.63", 2, 0.25, 200, 0.25),
                new TrafficData("205.247.78.0", 1, 0.125, 100, 0.125)
        ));

        try (StringWriter writer = new StringWriter()) {
            reportPersister.saveReport(sample, writer);
            assertEquals(expected, toLines(writer));
        }
    }

    private static List<String> toLines(StringWriter writer) {
        return new BufferedReader(new StringReader(writer.getBuffer().toString())).lines().toList();
    }
}
