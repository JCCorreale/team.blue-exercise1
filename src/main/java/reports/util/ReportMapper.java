package reports.util;

import reports.model.Report;

import java.io.IOException;
import java.util.List;

public interface ReportMapper {

    Report parseReport(List<String> lines);

    List<String> formatReport(Report report) throws IOException;
}
