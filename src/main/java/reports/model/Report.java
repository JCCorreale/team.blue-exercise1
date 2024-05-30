package reports.model;

import java.util.List;

/**
 * Traffic data report.
 */
public class Report {

    /**
     * The data set must be sorted by the number of requests (DESC).
     */
    private final List<TrafficData> trafficData;

    public Report(List<TrafficData> trafficData) {
        this.trafficData = trafficData;
    }

    public List<TrafficData> getTrafficData() {
        return trafficData;
    }
}
