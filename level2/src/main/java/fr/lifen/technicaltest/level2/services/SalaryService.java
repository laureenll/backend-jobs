package fr.lifen.technicaltest.level2.services;

import fr.lifen.technicaltest.level2.dto.Data;
import fr.lifen.technicaltest.level2.dto.Output;
import fr.lifen.technicaltest.level2.models.Status;
import fr.lifen.technicaltest.level2.models.Worker;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryService {
    public static Output getAllSalariesByWorker(Data data) {
        final List<Worker> workersOutput = data.getWorkers().stream().peek(worker -> {
            long numberOfWorkingDays = data.getShifts()
                    .stream()
                    .filter(shift -> shift.getWorker().getId().equals(worker.getId()))
                    .count();
            worker.setPrice((int) (numberOfWorkingDays * worker.getStatus().getPricePerDay()));
        }).collect(Collectors.toList());
        return new Output(workersOutput);
    }
}
