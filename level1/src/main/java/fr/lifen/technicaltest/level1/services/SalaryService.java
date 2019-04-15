package fr.lifen.technicaltest.level1.services;

import fr.lifen.technicaltest.level1.dto.Output;
import fr.lifen.technicaltest.level1.models.Shift;
import fr.lifen.technicaltest.level1.models.Worker;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryService {
    public static Output getAllSalariesByWorker(List<Shift> shifts, List<Worker> workers) {
        final List<Worker> workersOutput = workers.stream().peek(worker -> {
            Long numberOfWorkingDays = shifts
                    .stream()
                    .filter(shift -> shift.getWorker().getId().equals(worker.getId()))
                    .count();
            worker.setPrice((int) (numberOfWorkingDays * worker.getPricePerShift()));
        }).collect(Collectors.toList());
        return new Output(workersOutput);
    }
}
