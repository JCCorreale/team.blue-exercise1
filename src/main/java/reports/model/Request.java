package reports.model;

import java.time.Instant;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return timestamp.equals(request.timestamp) && bytes.equals(request.bytes) && status.equals(request.status) && remoteAddr.equals(request.remoteAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, bytes, status, remoteAddr);
    }
}
