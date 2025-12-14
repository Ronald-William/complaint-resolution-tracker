package model;

import java.time.LocalDateTime;

public class Complaint {
    private int id;
    private String category;
    private String description;
    private ComplaintStatus status;
    private String assignedTo;
    private LocalDateTime createdAt;

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
                '}';
    }
}
