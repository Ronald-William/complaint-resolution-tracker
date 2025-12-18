package model;

public class Complaint {

    private int id;
    private String category;
    private String description;
    private String handler;
    private ComplaintStatus status;

    public Complaint(int id, String category, String description) {
        this.id = id;
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

    public void assignHandler(String handler) {
        this.handler = handler;
        this.status = ComplaintStatus.IN_PROGRESS;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }
}
