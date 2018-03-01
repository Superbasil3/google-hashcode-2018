package file_parser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class WriteFile {

    public static void writeFileToPath(String path, Map<String, Object> resultObject) throws IOException {
        try {
            for (Map.Entry entry : resultObject.entrySet()) {
                long timeStart = System.currentTimeMillis();

                PrintWriter fileResult = new PrintWriter(new FileWriter(path + entry.getKey().toString().replace("in","out")));

                writeAnswerToFile(fileResult, entry.getValue());
                fileResult.close();

                System.out.println((System.currentTimeMillis() - timeStart) / 1000 + "second to write file " + entry.getKey().toString().replace("in","out"));
            }
        } catch (Exception e) {

        }
    }

    private static void writeAnswerToFile(PrintWriter fileResult, Object value) {
        if (value instanceof String) {
            fileResult.println(value);
        }
    }
}
