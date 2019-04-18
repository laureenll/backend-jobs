package fr.lifen.technicaltest.level5.controller.request;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ShiftRequest {

    @NotNull(message = "start date must not be null!")
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
