package file_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadFile {


    public static Map<String, Object> getFileFromPath(String pathFile) throws IOException {
        Map<String, Object> holder = new HashMap<>();

        List<Path> paths = Files.find(Paths.get(pathFile), 5, (path, attr) -> path.toString().toLowerCase().endsWith(".in"))
                .collect(Collectors.toList());
        for (Path file : paths) {
            String filename = file.getFileName().toString();

            try (BufferedReader br = new BufferedReader(new FileReader(file.toAbsolutePath().toString()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                holder.put(filename, "TOTO");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return holder;
    }

}
