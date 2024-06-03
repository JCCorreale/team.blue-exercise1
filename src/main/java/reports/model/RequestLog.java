package reports.model;

import java.util.List;
import java.util.Objects;

/**
 * A collection of request logs.
 */
public class RequestLog {

    private final List<Request> requests;

    public RequestLog(List<Request> requests) {
        this.requests = requests;
    }

    public List<Request> getRequests() {
        return requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLog that = (RequestLog) o;
        return requests.equals(that.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requests);
    }
}
