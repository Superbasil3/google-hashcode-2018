package fun.google.hash_code_2018.file_parser;

import fun.google.hash_code_2018.model.Maps;
import fun.google.hash_code_2018.model.Ride;
import fun.google.hash_code_2018.model.Vehicle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class WriteFile {

    public static void writeFileToPath(Map<String, Maps> resultObject) throws IOException {
        try {
            for (Map.Entry entry : resultObject.entrySet()) {
                long timeStart = System.currentTimeMillis();

                Path outputFolder = Paths.get("target\\output");
                Files.createDirectories(outputFolder);

                String outputFileName = outputFolder.resolve(entry.getKey().toString().replace("in", "out")).toString();
                PrintWriter fileResult = new PrintWriter(new FileWriter(outputFileName));

                writeAnswerToFile(fileResult, (Maps) entry.getValue());
                fileResult.close();

                System.out.println((System.currentTimeMillis() - timeStart) / 1000 + " seconds to write file " + entry.getKey().toString().replace("in", "out"));
            }
        } catch (Exception e) {

        }
    }

    private static void writeAnswerToFile(PrintWriter fileResult, Maps value) {
        for(Vehicle vehicule : value.getListVehicles()){
            fileResult.println(vehicule.getStringToFile());
        }
    }
}
