package fr.lifen.technicaltest.level5.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    medic("medic"),
    interne("interne"),
    interim("interim");

    private String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
