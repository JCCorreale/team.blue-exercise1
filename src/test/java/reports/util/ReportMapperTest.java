package reports.util;

import org.junit.jupiter.api.Test;
import reports.model.Report;
import reports.model.TrafficData;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportMapperTest {

    @Test
    void testParseReport() throws IOException {

        Report actual = new ReportMapper()
                .parseReportCSV(TestUtils.readTextResource("expected/ipaddr1.csv"));

        Report expected = new Report(List.of(
                new TrafficData(
                "150.23.122.180",
                2,
                1.0,
                250,
                1.0
        )));

        assertEquals(expected, actual);
    }


}
