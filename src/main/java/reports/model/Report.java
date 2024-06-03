package reports.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return trafficData.equals(report.trafficData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trafficData);
    }
}
