package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Complaint {

    private int id;
    private String category;
    private String description;
    private String handler;
    private ComplaintStatus status;
    private LocalDateTime createdAt;
    private List<String> history;

    public Complaint(int id, String category, String description) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.status = ComplaintStatus.OPEN;
        this.createdAt = LocalDateTime.now();
        this.history = new ArrayList<>();
        history.add("CREATED at " + createdAt);
    }

    public int getId() {
        return id;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void assignHandler(String handler) {
        this.handler = handler;
        this.status = ComplaintStatus.IN_PROGRESS;
        history.add("ASSIGNED to " + handler + " at " + LocalDateTime.now());
    }

    public void resolve() {
        this.status = ComplaintStatus.RESOLVED;
        history.add("RESOLVED at " + LocalDateTime.now());
    }

    public void close() {
        this.status = ComplaintStatus.CLOSED;
        history.add("CLOSED at " + LocalDateTime.now());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Complaint{id=").append(id)
          .append(", category='").append(category).append('\'')
          .append(", description='").append(description).append('\'')
          .append(", handler='").append(handler).append('\'')
          .append(", status=").append(status)
          .append("}\n");

        for (String entry : history) {
            sb.append("  - ").append(entry).append("\n");
        }
        return sb.toString();
    }
}
