package giuseppetavella.web_api_blogging_image_upload.payloads;

import java.time.LocalDateTime;

public class ErrorsPayload {
    
    private final String message;
    private final LocalDateTime timestamp;
    
    public ErrorsPayload(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public ErrorsPayload(String message) {
        this(message, LocalDateTime.now());
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
