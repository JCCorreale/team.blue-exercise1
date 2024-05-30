package reports.model;

import java.time.Instant;

/**
 * Record of the request log.
 */
public class Request {

    private final Instant timestamp;
    private final Integer bytes;
    private final Integer status;
    private final String remoteAddr;

    public Request(Instant timestamp, Integer bytes, Integer status, String remoteAddr) {
        this.timestamp = timestamp;
        this.bytes = bytes;
        this.status = status;
        this.remoteAddr = remoteAddr;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getBytes() {
        return bytes;
    }

    public Integer getStatus() {
        return status;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }
}
