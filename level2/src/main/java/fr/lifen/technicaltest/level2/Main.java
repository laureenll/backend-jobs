package fr.lifen.technicaltest.level2;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.lifen.technicaltest.level2.dto.Data;
import fr.lifen.technicaltest.level2.dto.Output;
import fr.lifen.technicaltest.level2.services.SalaryService;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final Data data = mapper.readValue(new File( "level2/src/main/resources/data.json"), Data.class);
        final Output allSalariesByWorker = SalaryService.getAllSalariesByWorker(data);

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("level2/src/main/resources/output_result_level2.json"), allSalariesByWorker);
    }
}
