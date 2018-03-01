package fun.google.hash_code_2018.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicle {
    private final int vehicleId;
    private final List<Ride> rides = new ArrayList<>();
    private final List<RideScore> rideScores = new ArrayList<>();
    private int x;
    private int y;
    private int stepBusy = 0;

    public Vehicle(int vehicleId) {
        this.vehicleId = vehicleId;
        this.x = 0;
        this.y = 0;
    }

    public List<RideScore> getRideScores() {
        return rideScores;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void calculateScore(List<Ride> listRides) {
        rideScores.clear();
        if (!available()) {
            stepBusy--;
            return;
        }

        listRides.forEach(r -> {
            RideScore rideScore = new RideScore();
            rideScore.setVehicleId(vehicleId);
            rideScore.setRide(r);
            rideScore.setScore(r.getEarliestStart());
            rideScores.add(rideScore);
        });
        rideScores.sort(Comparator.comparingInt(RideScore::getScore));
    }

    public void affect(RideScore rideScore) {
        rides.add(rideScore.getRide());
        rideScore.getRide().setAffectedVehicle(this);

        int timeToDestination = timeToGoTo(rideScore.getRide());
        int pickUpTime = Math.max(timeToDestination, rideScore.getRide().getEarliestStart());
        stepBusy = pickUpTime + rideScore.getRide().getDuration();
    }

    public boolean available() {
        return stepBusy <= 0;
    }

    private int timeToGoTo(Ride ride) {
        int durationY = (ride.getStartB() > this.y) ? (ride.getStartB() - this.y) :  this.y - ride.getStartB();
        int durationX = (ride.getStartA() > this.x) ? (ride.getStartA() - this.x) :  this.x - ride.getStartA();
        return durationY + durationX;
    }

    public String getStringToFile() {
        return vehicleId + " " + rides.stream().map(ride -> String.valueOf(ride.getRideId())).collect(Collectors.joining(" "));
    }
}
