package fr.lifen.technicaltest.level4.services;

import fr.lifen.technicaltest.level4.dto.Data;
import fr.lifen.technicaltest.level4.dto.Output;
import fr.lifen.technicaltest.level4.models.Commission;
import fr.lifen.technicaltest.level4.models.Shift;
import fr.lifen.technicaltest.level4.models.Status;
import fr.lifen.technicaltest.level4.models.Worker;

import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SalaryService {
    public static Output getAllSalariesByWorkerWithCommission(Data data) {
        final Commission commission = new Commission();
        final int numberOfInterimShifts = (int) data.getShifts()
                .stream()
                .filter(shift -> shift.getWorker() != null)
                .filter(shift -> shift.getWorker().getStatus().equals(Status.INTERIM))
                .peek(shift -> commission.addFee(80))
                .count();


        final List<Worker> workersOutput = data.getWorkers().stream().peek(worker -> {
            final List<Shift> shiftsForCurrentWorker = data.getShifts()
                    .stream()
                    .filter(shift -> shift.getWorker() != null)
                    .filter(shift -> shift.getWorker().getId().equals(worker.getId()))
                    .collect(Collectors.toList());

            final IntStream priceForWeekStream = shiftsForCurrentWorker
                    .stream()
                    .filter(shift -> !shift.isWeekEnd())
                    .mapToInt(shift -> shift.getWorker().getStatus().getPricePerDay());

            final IntStream priceForWeekEndStream = shiftsForCurrentWorker
                    .stream()
                    .filter(Shift::isWeekEnd)
                    .mapToInt(shift -> shift.getWorker().getStatus().getPriceInWeekEnd());

            int price = IntStream.concat(priceForWeekEndStream, priceForWeekStream)
                    .peek(shiftPrice -> commission.addFee(shiftPrice*0.05)) // changeme : not taking part of interim
                    .sum();

            worker.setPrice(price);
        }).collect(Collectors.toList());

        commission.setInterimShifts(numberOfInterimShifts);

        return new Output(workersOutput, commission);
    }
}
