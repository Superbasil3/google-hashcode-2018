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

            final Maps maps = new Maps();

            try (Stream<String> stream = Files.lines(Paths.get(file.toString()))) {
                stream.forEach((String line) -> {
                    String[] lineParsed = line.split(" ");
                    if (!maps.initialized()) {
                        maps.update(lineParsed[0], lineParsed[1], lineParsed[2], lineParsed[3], lineParsed[4], lineParsed[5]);
                    } else {
                        Ride ride = new Ride(lineParsed[0], lineParsed[1], lineParsed[2], lineParsed[3], lineParsed[4], lineParsed[5]);
                        maps.addRide(ride);
                    }
                });

                holder.put(filename, maps);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println((System.currentTimeMillis() - timeStart) / 1000 + " seconds to parse file " + filename);

            for (int i = 0; i < maps.getSteps(); i++) {
                // Select next ride
                int remainingSteps = maps.getSteps() - i;
                int currentStep = i;
                maps.getListVehicles().parallelStream().forEach(v -> v.calculateScores(currentStep, remainingSteps, maps.getListRides()));
                maps.getListVehicles().forEach(v -> {
                    v.getRideScores().stream().filter(rs -> rs.getRide().isAvailable())
                            .findFirst()
                            .ifPresent(rs -> v.affect(rs, maps.getListRides()));
                });
            }
        }
        return holder;
    }


}
