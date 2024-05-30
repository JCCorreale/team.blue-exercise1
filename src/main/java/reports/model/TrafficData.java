package reports.model;

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
}
