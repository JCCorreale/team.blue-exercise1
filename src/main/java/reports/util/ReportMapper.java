package reports.util;

import reports.model.Report;
import reports.model.TrafficData;

import java.util.Arrays;
import java.util.List;

public class ReportMapper {

    public static final String CSV_FIELD_SEPARATOR = ";";

    public Report parseReportCSV(List<String> lines) {
        return new Report(lines.stream().map(line -> {
            List<String> tokens = Arrays.stream(line.split(CSV_FIELD_SEPARATOR))
                    .map(String::trim)
                    .toList();
            return new TrafficData(
                    tokens.get(0),
                    Integer.parseInt(tokens.get(1)),
                    Double.parseDouble(tokens.get(2)),
                    Integer.parseInt(tokens.get(3)),
                    Double.parseDouble(tokens.get(4))
            );
        }).toList());
    }

}
