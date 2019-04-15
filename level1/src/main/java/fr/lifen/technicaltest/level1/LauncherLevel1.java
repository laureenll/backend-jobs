package fr.lifen.technicaltest.level1;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.lifen.technicaltest.level1.dto.Data;
import fr.lifen.technicaltest.level1.dto.Output;
import fr.lifen.technicaltest.level1.services.SalaryService;

import java.io.File;
import java.io.IOException;

public class LauncherLevel1 {
    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final Data data = mapper.readValue(new File( "level1/src/main/resources/data.json"), Data.class);

        final Output allSalariesByWorker = SalaryService.getAllSalariesByWorker(data.getShifts(), data.getWorkers());

        final ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("level1/src/main/resources/output_result_level1.json"), allSalariesByWorker);
    }
}
