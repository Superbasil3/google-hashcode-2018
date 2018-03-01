package fun.google.hash_code_2018.model;

import fun.google.hash_code_2018.file_parser.ReadFile;
import fun.google.hash_code_2018.main;

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

    public void calculateScores(int currentStep, int remainingSteps, List<Ride> listRides) {
        rideScores.clear();
        if (!available()) {
            stepBusy--;
            return;
        }

        listRides.forEach(r -> {
            int score = calculateScore(currentStep, remainingSteps, r);
            if (score >= 0) {
                RideScore rideScore = new RideScore();
                rideScore.setVehicleId(vehicleId);
                rideScore.setRide(r);
                rideScore.setScore(score);
                rideScores.add(rideScore);
            }
        });
        rideScores.sort(Comparator.comparingInt(RideScore::getScore));
    }

    private int calculateScore(int currentStep, int remainingSteps, Ride ride) {
        int timeToGoToRide = timeToGoTo(ride);
        int totalRideDuration = timeToGoToRide + ride.getDuration();
        if (totalRideDuration > remainingSteps) {
            return -1;
        }
        if (currentStep + totalRideDuration > ride.getLatestFinish()) {
            return -1;
        }

//        if (ReadFile.bonus > 200) {
//            return ride.getEarliestStart() - (timeToGoToRide - currentStep);
//        }

        int maxBonus = Math.abs(ride.getEarliestStart() - (currentStep + timeToGoToRide));
        return maxBonus;
        //return maxBonus + Math.max(ride.getEarliestStart(), (currentStep + timeToGoToRide)) + ride.getDuration();
    }

    public void affect(RideScore rideScore, List<Ride> listRides) {
        rides.add(rideScore.getRide());
        rideScore.getRide().setAffectedVehicle(this);

        int timeToDestination = timeToGoTo(rideScore.getRide());
        int pickUpTime = Math.max(timeToDestination, rideScore.getRide().getEarliestStart());
        stepBusy = pickUpTime + rideScore.getRide().getDuration();
        x = rideScore.getRide().getFinishX();
        y = rideScore.getRide().getFinishY();

        listRides.remove(rideScore.getRide());
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
        int sum = rides.stream().mapToInt(Ride::getSize).sum();
        return sum + " " + rides.stream().map(Ride::displayRideId).collect(Collectors.joining(" "));
    }
}
