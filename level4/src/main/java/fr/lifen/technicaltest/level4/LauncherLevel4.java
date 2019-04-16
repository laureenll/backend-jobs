package fr.lifen.technicaltest.level4;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.lifen.technicaltest.level4.dto.Data;
import fr.lifen.technicaltest.level4.dto.Output;
import fr.lifen.technicaltest.level4.services.SalaryService;

import java.io.File;
import java.io.IOException;

public class LauncherLevel4 {
    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final Data data = mapper.readValue(new File( "level4/src/main/resources/data.json"), Data.class);
        final Output allSalariesByWorker = SalaryService.getAllSalariesByWorkerWithCommission(data);

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("level4/src/main/resources/output_result_level4.json"), allSalariesByWorker);
    }
}
