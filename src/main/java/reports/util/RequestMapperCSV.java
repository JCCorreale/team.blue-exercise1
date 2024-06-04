package reports.util;

import reports.model.Request;
import reports.model.RequestLog;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class RequestMapperCSV {

    public static final String CSV_FIELD_SEPARATOR = ";";

    public RequestLog parseRequestLogCSV(List<String> lines) {
        return new RequestLog(lines.stream().map(line -> {
            List<String> tokens = Arrays.stream(line.split(CSV_FIELD_SEPARATOR))
                    .map(String::trim)
                    .toList();
            return new Request(
                    Instant.parse(tokens.get(0)),
                    Integer.parseInt(tokens.get(1)),
                    Integer.parseInt(tokens.get(2)),
                    tokens.get(3)
            );
        }).toList());
    }
}
