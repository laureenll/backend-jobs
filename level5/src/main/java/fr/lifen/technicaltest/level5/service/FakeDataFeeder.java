package fr.lifen.technicaltest.level5.service;

import fr.lifen.technicaltest.level5.Database;
import fr.lifen.technicaltest.level5.model.Shift;
import fr.lifen.technicaltest.level5.model.Status;
import fr.lifen.technicaltest.level5.model.Worker;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class FakeDataFeeder {
    private final Database database;

    public FakeDataFeeder(Database database) {
        this.database = database;
    }

    @PostConstruct
    public void feedDatabaseWithFakeData() {
        System.out.println("Start feed database");
        final Worker worker = new Worker("1", "michel", Status.interim);
        database.addWorker(worker);
        database.addWorker(new Worker("2", "paul", Status.interne));
        database.addWorker(new Worker("3", "eric", Status.medic));

        final Shift shift = new Shift("1", new Date());
        shift.setWorker(worker);
        database.addShift(shift);
        database.addShift(new Shift("2", new Date()));
        database.addShift(new Shift("3", new Date()));

        System.out.println("End feed database");
    }
}
