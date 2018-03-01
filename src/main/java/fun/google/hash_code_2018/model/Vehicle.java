package fun.google.hash_code_2018.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final int vehicleId;
    private final List<RideScore> rideScores = new ArrayList<>();

    public Vehicle(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public List<RideScore> getRideScores() {
        return rideScores;
    }

    public void calculateScore(List<Ride> listRides) {
        rideScores.clear();
        listRides.forEach(r -> {
            RideScore rideScore = new RideScore();
            rideScore.setRideId(r.getRideId());
            rideScores.add(rideScore)
        });
    }
}
