package fr.lifen.technicaltest.level5.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors;

    private final String errorMessage;

    public ValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
        errors = new ArrayList<>();
    }

    public void addValidationError(String error) {
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
