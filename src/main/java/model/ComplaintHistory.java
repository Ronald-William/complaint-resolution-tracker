package model;

import java.time.LocalDateTime;

public class ComplaintHistory {
    private String action;
    private LocalDateTime timestamp;

    public ComplaintHistory(String action) {
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
