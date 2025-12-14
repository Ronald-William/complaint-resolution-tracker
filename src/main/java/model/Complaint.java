package model;

import java.util.ArrayList;
import java.util.List;

public class Complaint {

    private int id;
    private String category;
    private String description;
    private String handler;
    private ComplaintStatus status;
    private List<ComplaintHistory> history = new ArrayList<>();

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

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getHandler() {
        return handler;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    // ✅ THIS IS WHAT WAS MISSING
    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public void addHistory(String action) {
        history.add(new ComplaintHistory(action));
    }

    public List<ComplaintHistory> getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", handler='" + handler + '\'' +
                ", status=" + status +
                '}';
    }
}
