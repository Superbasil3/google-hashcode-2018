package fun.google.hash_code_2018.file_parser;

import fun.google.hash_code_2018.model.Maps;
import fun.google.hash_code_2018.model.Ride;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {


    public static Map<String, Maps> getFileFromPath() throws IOException, URISyntaxException {
        Map<String, Maps> holder = new HashMap<>();

        List<Path> paths = Files.find(Paths.get(ClassLoader.getSystemResource("inputs").toURI()), 5, (path, attr) -> path.toString().toLowerCase().endsWith(".in"))
                .sorted((path2, path1) -> path1.getFileName().toString().compareTo(path2.getFileName().toString()))
                .collect(Collectors.toList());
        for (Path file : paths) {
            String filename = file.getFileName().toString();
            long timeStart = System.currentTimeMillis();

            try (Stream<String> stream = Files.lines(Paths.get(file.toString()))) {
                final Maps[] maps = {new Maps()};

                stream.forEach((String line) -> {
                    String[] lineParsed = line.split(" ");
                    if (!maps[0].initialized()) {
                        maps[0] = new Maps(lineParsed[0], lineParsed[1], lineParsed[2], lineParsed[3], lineParsed[4], lineParsed[5]);
                    } else {
                        Ride ride = new Ride(lineParsed[0], lineParsed[1], lineParsed[2], lineParsed[3], lineParsed[4], lineParsed[5]);
                        maps[0].addRide(ride);
                    }
                });

                holder.put(filename, maps[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println((System.currentTimeMillis() - timeStart) / 1000 + " seconds to parse file " + filename);
        }
        return holder;
    }


}
