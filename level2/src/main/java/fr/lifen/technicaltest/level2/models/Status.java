package fr.lifen.technicaltest.level2.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Status {
    MEDIC("medic", 270),
    INTERNE("interne", 126);

    private String value;
    private int pricePerDay;

    Status(String value, int pricePerDay) {
        this.value = value;
        this.pricePerDay = pricePerDay;
    }

    @JsonCreator
    public static Status forValue(String value) {
        return Arrays.stream(values()).filter(status -> status.value.equals(value))
                .findAny().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }
}
