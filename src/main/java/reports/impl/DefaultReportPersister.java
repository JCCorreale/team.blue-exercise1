package reports.impl;

import reports.interfaces.ReportPersister;
import reports.model.Report;
import reports.util.ReportMapper;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class DefaultReportPersister implements ReportPersister {

    private final ReportMapper reportMapper;

    public DefaultReportPersister(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    @Override
    public void saveReport(Report report, Writer writer) throws IOException {
        List<String> lines = reportMapper.formatReport(report);
        for (int i = 0; i < lines.size(); i++) {
            writer.append(lines.get(i));
            if (i < lines.size() - 1)
                writer.append(System.lineSeparator());
        }
    }
}
