package fun.google.hash_code_2018.file_parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {


    public static Map<String, Object> getFileFromPath(String pathFile) throws IOException {
        Map<String, Object> holder = new HashMap<>();

        List<Path> paths = Files.find(Paths.get(pathFile), 5, (path, attr) -> path.toString().toLowerCase().endsWith(".in"))
                .sorted((path2,path1) -> path1.getFileName().toString().compareTo(path2.getFileName().toString()))
                .collect(Collectors.toList());
        for (Path file : paths) {
            String filename = file.getFileName().toString();
            long timeStart = System.currentTimeMillis();

            try (Stream<String> stream = Files.lines(Paths.get(file.toString()))) {

                stream.forEach(line -> {
                    if (line.contains("TT")) {

                    } else {

                    }
               });

                holder.put(filename,filename);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println((System.currentTimeMillis() - timeStart) / 1000 + " seconds to parse file " + filename);


        }
        return holder;
    }


}
