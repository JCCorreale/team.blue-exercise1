package reports.util;

import org.junit.jupiter.api.Test;
import reports.model.Request;
import reports.model.RequestLog;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestMapperTest {

    @Test
    void testParseRequestLog() throws IOException {

        RequestLog actual = new RequestMapper()
                .parseRequestLogCSV(TestUtils.readTextResource("samples/requests1.csv"));

        RequestLog expected = new RequestLog(List.of(
                new Request(OffsetDateTime.of(2024, 5, 30, 18, 0, 0, 0, ZoneOffset.UTC).toInstant(),
                        100,
                        200,
                        "150.23.122.180"),
                new Request(OffsetDateTime.of(2024, 5, 30, 18, 10, 0, 0, ZoneOffset.UTC).toInstant(),
                        150,
                        200,
                        "150.23.122.180"),
                new Request(OffsetDateTime.of(2024, 5, 30, 18, 11, 0, 0, ZoneOffset.UTC).toInstant(),
                        150,
                        500,
                        "150.23.122.180")
        ));

        assertEquals(expected, actual);
    }
}