package fr.lifen.technicaltest.level5.controller.request;

import fr.lifen.technicaltest.level5.model.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WorkerRequest {

    @NotBlank(message = "Firstname name must not be blank!")
    private String firstName;

    @NotNull(message = "Status name must not be empty!")
    private Status status;

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
