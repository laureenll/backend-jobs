package fr.lifen.technicaltest.level4.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Date;

public class Shift {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("planning_id")
    private Long planningId;

    @JsonProperty("user_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Worker worker;

    @JsonProperty("start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-M-d")
    private Date startDate;

    public Shift() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanningId() {
        return planningId;
    }

    public void setPlanningId(Long planningId) {
        this.planningId = planningId;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isWeekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.startDate);
        final int daysOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        return daysOfTheWeek == Calendar.SUNDAY || daysOfTheWeek == Calendar.SATURDAY;
    }
}
