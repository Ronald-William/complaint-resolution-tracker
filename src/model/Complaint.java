package model;

import java.time.LocalDateTime;

public class Complaint {
    private int id;
    private String category;
    private String description;
    private ComplaintStatus status;
    private String assignedTo;
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;

    public Complaint(int id, String category, String description) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.status = ComplaintStatus.OPEN;
        this.createdAt = LocalDateTime.now();
    }

    public void assignTo(String handler) {
        this.assignedTo = handler;
        this.status = ComplaintStatus.IN_PROGRESS;
    }

    public void resolve() {
        if (status == ComplaintStatus.IN_PROGRESS) {
            this.status = ComplaintStatus.RESOLVED;
            this.resolvedAt = LocalDateTime.now();
        }
    }

    public void close() {
        if (status == ComplaintStatus.RESOLVED) {
            this.status = ComplaintStatus.CLOSED;
        }
    }

    public int getId() {
        return id;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", status=" + status +
                ", assignedTo='" + assignedTo + '\'' +
                ", resolvedAt=" + resolvedAt +
                '}';
    }
}
