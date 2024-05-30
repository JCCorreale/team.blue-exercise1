package reports.interfaces;


import reports.model.Report;

public interface ReportPersister {

    void saveReport(Report report);
}
