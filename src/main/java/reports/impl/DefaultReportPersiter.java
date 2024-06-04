package reports.impl;

import reports.interfaces.ReportPersister;
import reports.model.Report;
import reports.util.ReportMapperCSV;

import java.io.IOException;
import java.io.Writer;

public class DefaultReportPersiter implements ReportPersister {

    private final ReportMapperCSV reportMapper;

    public DefaultReportPersiter(ReportMapperCSV reportMapper) {
        this.reportMapper = reportMapper;
    }

    @Override
    public void saveReport(Report report, Writer writer) throws IOException {
        for (String line : reportMapper.formatReportCSV(report)) {
            writer.write("%s%n".formatted(line));
        }
    }
}
