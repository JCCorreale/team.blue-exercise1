package reports.impl;

import reports.interfaces.ReportGenerator;
import reports.model.Report;
import reports.model.RequestLog;
import reports.model.TrafficData;

import java.util.HashMap;
import java.util.Map;

public class DefaultReportGenerator implements ReportGenerator {
    @Override
    public Report generateReport(RequestLog log) {
        Map<String, SimpleTrafficData> trafficData = (log.getRequests().stream().collect(
                HashMap::new,
                (entries, request) -> {

                    if (request.getStatus() != 200)
                        return;

                    entries.merge(
                        request.getRemoteAddr(),
                        new SimpleTrafficData(request.getRemoteAddr(), 1, request.getBytes()),
                        SimpleTrafficData::merge
                    );
                },
                (a, b) -> {} /* not used in non parallel stream */
        ));

        Double totalBytes = trafficData.values().stream().mapToDouble(SimpleTrafficData::bytes).sum();
        Double totalRequests = trafficData.values().stream().mapToDouble(SimpleTrafficData::requests).sum();

        return new Report(
                trafficData.values().stream().map(td ->
                        td.toTrafficData(totalBytes, totalRequests)
                ).toList()
        );
    }

    private record SimpleTrafficData(
            String ip,
            Integer requests,
            Integer bytes
    ) {
        public SimpleTrafficData merge(SimpleTrafficData other) {
            return new SimpleTrafficData(other.ip(), requests() + other.requests(), bytes() + other.bytes());
        }

        public TrafficData toTrafficData(Double totalBytes, Double totalRequests) {
            return new TrafficData(
                    ip(),
                    requests(),
                    requests().doubleValue() / totalRequests,
                    bytes(),
                    bytes().doubleValue() / totalBytes
            );
        }
    }
}