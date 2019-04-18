package fr.lifen.technicaltest.level5.model;

public class Worker {
    private String id;

    private String firstName;

    private Status status;

    public Worker() {
    }

    public Worker(String id, String firstName, Status status) {
        this.id = id;
        this.firstName = firstName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
