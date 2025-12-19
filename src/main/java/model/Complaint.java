package model;

public class Complaint {

    private int id;
    private String category;
    private String description;
    private String handler;
    private ComplaintStatus status;

    public Complaint(int id, String category, String description, String handler, ComplaintStatus status) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.handler = handler;
        this.status = status;
    }

    public Complaint(String category, String description) {
        this.category = category;
        this.description = description;
        this.status = ComplaintStatus.OPEN;
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

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Category: " + category +
                " | Description: " + description +
                " | Handler: " + handler +
                " | Status: " + status;
    }
}
