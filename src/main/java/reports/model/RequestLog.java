package reports.model;

import java.util.List;

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
}
