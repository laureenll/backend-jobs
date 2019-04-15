package fr.lifen.technicaltest.level3.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Status {
    MEDIC("medic", 270, 540),
    INTERNE("interne", 126, 252);

    private String value;
    private int pricePerDay;
    private int priceInWeekEnd;

    Status(String value, int pricePerDay, int priceInWeekEnd) {
        this.value = value;
        this.pricePerDay = pricePerDay;
        this.priceInWeekEnd = priceInWeekEnd;
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

    public int getPriceInWeekEnd() {
        return priceInWeekEnd;
    }
}
