package reports.interfaces;

import reports.model.Report;
import reports.model.RequestLog;

public interface ReportGenerator {

    Report generateReport(RequestLog requests);
}
