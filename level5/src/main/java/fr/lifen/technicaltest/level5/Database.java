package fr.lifen.technicaltest.level5;

import fr.lifen.technicaltest.level5.model.Shift;
import fr.lifen.technicaltest.level5.model.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/***
 * This class simulate local database
 */
@Component
public class Database {
    private List<Worker> workers = new ArrayList<>();
    private List<Shift> shifts = new ArrayList<>();

    public Worker getWorkerById(String id) {
        return workers.stream().filter(worker -> worker.getId().equals(id)).findFirst().orElse(null);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void updateWorker(Worker worker) {
        workers.removeIf(workerFilter -> workerFilter.getId().equals(worker.getId()));
        workers.add(worker);
    }

    public void addShift(Shift shift) {
        shifts.add(shift);
    }

    public void updateShift(Shift shift) {
        shifts.removeIf(shiftFilter -> shiftFilter.getId().equals(shift.getId()));
        shifts.add(shift);
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public Shift getShiftById(String shiftId) {
        return shifts.stream().filter(shift -> shift.getId().equals(shiftId)).findFirst().orElse(null);
    }
}
