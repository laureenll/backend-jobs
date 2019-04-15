package fr.lifen.technicaltest.level2.dto;

import fr.lifen.technicaltest.level2.models.Shift;
import fr.lifen.technicaltest.level2.models.Worker;

import java.util.List;

public class Data {
    private List<Worker> workers;
    private List<Shift> shifts;

    public Data() {
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
