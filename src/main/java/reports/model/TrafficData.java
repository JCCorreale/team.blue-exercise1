package reports.model;

import java.util.Objects;

/**
 * Traffic data for a particular IP address.
 */
public class TrafficData {
    private final String ipAddress;
    private final Integer numberOfRequests;
    private final Double percentageOfTotalRequests;
    private final Integer bytesSent;
    private final Double percentageOfTotalBytesSent;

    public TrafficData(String ipAddress, Integer numberOfRequests, Double percentageOfTotalRequests, Integer bytesSent, Double percentageOfTotalBytesSent) {
        this.ipAddress = ipAddress;
        this.numberOfRequests = numberOfRequests;
        this.percentageOfTotalRequests = percentageOfTotalRequests;
        this.bytesSent = bytesSent;
        this.percentageOfTotalBytesSent = percentageOfTotalBytesSent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Integer getNumberOfRequests() {
        return numberOfRequests;
    }

    public Double getPercentageOfTotalRequests() {
        return percentageOfTotalRequests;
    }

    public Integer getBytesSent() {
        return bytesSent;
    }

    public Double getPercentageOfTotalBytesSent() {
        return percentageOfTotalBytesSent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficData that = (TrafficData) o;
        return ipAddress.equals(that.ipAddress) && numberOfRequests.equals(that.numberOfRequests) && percentageOfTotalRequests.equals(that.percentageOfTotalRequests) && bytesSent.equals(that.bytesSent) && percentageOfTotalBytesSent.equals(that.percentageOfTotalBytesSent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, numberOfRequests, percentageOfTotalRequests, bytesSent, percentageOfTotalBytesSent);
    }
}
