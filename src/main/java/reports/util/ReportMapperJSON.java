package reports.util;

import com.fasterxml.jackson.jr.ob.JSON;
import reports.model.Report;

import java.io.IOException;
import java.util.List;

public class ReportMapperJSON implements ReportMapper {
    @Override
    public Report parseReport(List<String> lines) {
        throw new UnsupportedOperationException();
    }

    public List<String> formatReport(Report report) {
        try {
            return List.of(JSON.std.asString(report));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}