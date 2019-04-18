package fr.lifen.technicaltest.level5.controller;

import fr.lifen.technicaltest.level5.Database;
import fr.lifen.technicaltest.level5.controller.request.ShiftRequest;
import fr.lifen.technicaltest.level5.model.Shift;
import fr.lifen.technicaltest.level5.model.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/shift")
public class ShiftController {
    private final Database database;

    public ShiftController(Database database) {
        this.database = database;
    }

    @PostMapping
    public ResponseEntity addShift(@Valid @RequestBody ShiftRequest shiftRequest, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
        }

        final UUID uuid = UUID.randomUUID();
        final Shift shift = new Shift(uuid.toString(), shiftRequest.getStartDate());

        database.addShift(shift);
        return ResponseEntity.ok(shift);
    }

    @GetMapping
    public ResponseEntity getShifts() {
        return ResponseEntity.ok(database.getShifts());
    }


    @PutMapping("/{shiftId}/{workerId}")
    public ResponseEntity assignWorkerToShift(@PathVariable String shiftId, @PathVariable String workerId) {
        final Shift shiftToUpdate = database.getShiftById(shiftId);
        if (shiftToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        final Worker workerToAssign = database.getWorkerById(workerId);
        if (workerToAssign == null) {
            return ResponseEntity.badRequest().build();
        }

        shiftToUpdate.setWorker(workerToAssign);
        database.updateShift(shiftToUpdate);

        return ResponseEntity.ok(shiftToUpdate);
    }
}
