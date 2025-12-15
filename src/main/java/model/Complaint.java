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
    private List<String> history = new ArrayList<>();

    public Complaint(int id, String category, String description) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.status = ComplaintStatus.OPEN;
        addHistory("CREATED");
    }

    public int getId() {
        return id;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void assignHandler(String handler) {
        if (status != ComplaintStatus.OPEN) {
            throw new RuntimeException("Complaint must be OPEN to assign handler");
        }
        this.handler = handler;
        this.status = ComplaintStatus.IN_PROGRESS;
        addHistory("ASSIGNED to " + handler);
    }

    public void resolve() {
        if (status != ComplaintStatus.IN_PROGRESS) {
            throw new RuntimeException("Complaint must be IN_PROGRESS to resolve");
        }
        this.status = ComplaintStatus.RESOLVED;
        addHistory("RESOLVED");
    }

    public void close() {
        if (status != ComplaintStatus.RESOLVED) {
            throw new RuntimeException("Complaint must be RESOLVED to close");
        }
        this.status = ComplaintStatus.CLOSED;
        addHistory("CLOSED");
    }

    private void addHistory(String action) {
        history.add(action + " at " + LocalDateTime.now());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Complaint{")
          .append("id=").append(id)
          .append(", category='").append(category).append('\'')
          .append(", description='").append(description).append('\'')
          .append(", handler='").append(handler).append('\'')
          .append(", status=").append(status)
          .append("}\n");

        for (String h : history) {
            sb.append("  - ").append(h).append("\n");
        }

        return sb.toString();
    }
}
