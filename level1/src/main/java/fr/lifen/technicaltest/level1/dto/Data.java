package fr.lifen.technicaltest.level1.dto;

import fr.lifen.technicaltest.level1.models.Shift;
import fr.lifen.technicaltest.level1.models.Worker;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Worker> workers;
    private List<Shift> shifts;

    public Data() {
        workers = new ArrayList<>();
        shifts = new ArrayList<>();
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}
