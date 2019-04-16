package fr.lifen.technicaltest.level4.dto;

import fr.lifen.technicaltest.level4.models.Commission;
import fr.lifen.technicaltest.level4.models.Worker;

import java.util.List;

public class Output {
    private final List<Worker> workers;
    private final Commission commission;

    public Output(List<Worker> workers, Commission commission) {
        this.workers = workers;
        this.commission = commission;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public Commission getCommission() {
        return commission;
    }
}
