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

    private List<Ride> listRides = new ArrayList<>();

    public Maps() {

    }

    public Maps(String rows, String columns, String vehicles, String rides, String bonus, String steps) {
        this.rows =  Integer.parseInt(rows);
        this.columns =Integer.parseInt(columns);
        this.vehicles =Integer.parseInt(vehicles);
        this.rides =Integer.parseInt(rides);
        this.bonus =Integer.parseInt(bonus);
        this.steps =Integer.parseInt(steps);
        initialized = true;
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
        listRides.add(ride);
    }

    public void setListRides(List<Ride> listRides) {
        this.listRides = listRides;
    }

    public boolean initialized() {
        return initialized;
    }
}
