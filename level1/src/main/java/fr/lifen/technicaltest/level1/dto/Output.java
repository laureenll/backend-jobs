package fr.lifen.technicaltest.level1.dto;

import fr.lifen.technicaltest.level1.models.Worker;

import java.util.List;

public class Output {
    private final List<Worker> workers;

    public Output(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
