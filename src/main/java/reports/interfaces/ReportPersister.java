package reports.interfaces;


import reports.model.Report;

import java.io.IOException;
import java.io.Writer;

public interface ReportPersister {

    void saveReport(Report report, Writer bufferedWriter) throws IOException;
}
