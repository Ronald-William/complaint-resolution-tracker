package model;

import java.time.LocalDateTime;

public class Complaint {
    private int id;
    private String category;
    private String description;
    private ComplaintStatus status;
    private LocalDateTime createdAt;

    public Complaint(int id, String category, String description) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.status = ComplaintStatus.OPEN;
        this.createdAt = LocalDateTime.now();

    }

    @Override
    public String toString() {
        return "Complaint{id=" + id +
                ", category='" + category + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt + '}';
    }

}
