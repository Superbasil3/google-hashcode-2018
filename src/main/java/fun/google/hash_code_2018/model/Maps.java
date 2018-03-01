package fun.google.hash_code_2018.model;

import java.util.ArrayList;
import java.util.List;

public class Maps {

    private boolean initialized;
    private int rows;
    private int columns;
    private int vehicles;
    private int rides;
    private int bonus;
    private int steps;

    private final List<Ride> listRides = new ArrayList<>();
    private final List<Vehicle> listVehicles = new ArrayList<>();

    public Maps() {

    }

    public void update(String rows, String columns, String vehicles, String rides, String bonus, String steps) {
        this.rows =  Integer.parseInt(rows);
        this.columns =Integer.parseInt(columns);
        this.vehicles =Integer.parseInt(vehicles);
        this.rides =Integer.parseInt(rides);
        this.bonus =Integer.parseInt(bonus);
        this.steps =Integer.parseInt(steps);
        initialized = true;
        for (int i = 0; i < this.vehicles; i++) {
            this.listVehicles.add(new Vehicle(i + 1));
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    public int getRides() {
        return rides;
    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public List<Ride> getListRides() {
        return listRides;
    }

    public void addRide(Ride ride) {
        ride.setRideId(listRides.size());
        listRides.add(ride);
    }

    public List<Vehicle> getListVehicles() {
        return listVehicles;
    }

    public boolean initialized() {
        return initialized;
    }

}
