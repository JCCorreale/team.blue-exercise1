package reports.interfaces;

import reports.model.Report;
import reports.model.RequestLog;

public class DummyReportGenerator implements ReportGenerator {
    @Override
    public Report generateReport(RequestLog requests) {
        return null;
    }
}
