package fr.lifen.technicaltest.level5.model;

import java.util.Date;

public class Shift {
    private String id;

    private Worker worker;

    private Date startDate;

    public Shift() {
    }

    public Shift(String id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
