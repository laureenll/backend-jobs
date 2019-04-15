package fr.lifen.technicaltest.level3.services;

import fr.lifen.technicaltest.level3.dto.Data;
import fr.lifen.technicaltest.level3.dto.Output;
import fr.lifen.technicaltest.level3.models.Shift;
import fr.lifen.technicaltest.level3.models.Worker;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryService {
    public static Output getAllSalariesByWorker(Data data) {
        final List<Worker> workersOutput = data.getWorkers().stream().peek(worker -> {
            final List<Shift> shiftsForCurrentWorker = data.getShifts()
                    .stream()
                    .filter(shift -> shift.getWorker() != null)
                    .filter(shift -> shift.getWorker().getId().equals(worker.getId()))
                    .collect(Collectors.toList());
            final int priceForWeek = shiftsForCurrentWorker
                    .stream()
                    .filter(shift -> !shift.isWeekEnd())
                    .mapToInt(shift -> shift.getWorker().getStatus().getPricePerDay())
                    .sum();
            final int priceForWeekEnd = shiftsForCurrentWorker
                    .stream()
                    .filter(Shift::isWeekEnd)
                    .mapToInt(shift -> shift.getWorker().getStatus().getPriceInWeekEnd())
                    .sum();

            worker.setPrice(priceForWeek + priceForWeekEnd);
        }).collect(Collectors.toList());
        return new Output(workersOutput);
    }
}
