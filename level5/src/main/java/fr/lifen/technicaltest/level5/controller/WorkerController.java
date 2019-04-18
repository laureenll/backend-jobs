package fr.lifen.technicaltest.level5.controller;

import fr.lifen.technicaltest.level5.Database;
import fr.lifen.technicaltest.level5.controller.request.WorkerRequest;
import fr.lifen.technicaltest.level5.model.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final Database database;

    public WorkerController(Database database) {
        this.database = database;
    }

    @PostMapping
    public ResponseEntity addWorker(@Valid @RequestBody WorkerRequest workerRequest, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
        }

        final UUID uuid = UUID.randomUUID();
        final Worker worker = new Worker(uuid.toString(), workerRequest.getFirstName(), workerRequest.getStatus());

        database.addWorker(worker);

        return ResponseEntity.ok(worker);
    }

    @GetMapping
    public ResponseEntity getWorkers() {
        return ResponseEntity.ok(database.getWorkers());
    }

    @PutMapping("/{id}")
    public ResponseEntity updateWorker(@PathVariable String id, @Valid @RequestBody WorkerRequest workerRequest, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
        }
        final Worker workerToUpdate = database.getWorkerById(id);
        if (workerToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        workerToUpdate.setFirstName(workerRequest.getFirstName());
        workerToUpdate.setStatus(workerRequest.getStatus());

        database.updateWorker(workerToUpdate);

        return ResponseEntity.ok(workerToUpdate);
    }

}
