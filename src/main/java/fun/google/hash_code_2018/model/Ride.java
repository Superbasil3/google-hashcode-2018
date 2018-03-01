package fun.google.hash_code_2018.model;

public class Ride {
    private int startA;
    private int startB;
    private int finishX;
    private int finishY;
    private int earliestStart;
    private int latestFinish;
    private final int duration;
    private Vehicle affectedVehicle;

    public Ride(String startA, String startB, String finishX, String finishY, String earliestStart, String latestFinish) {
        this.startA = Integer.parseInt(startA);
        this.startB = Integer.parseInt(startB);
        this.finishX = Integer.parseInt(finishX);
        this.finishY = Integer.parseInt(finishY);
        this.earliestStart = Integer.parseInt(earliestStart);
        this.latestFinish = Integer.parseInt(latestFinish);

        int durationY = (this.finishY > this.startB) ? (this.finishY - this.startB) :  this.startB - this.finishY;
        int durationX = (this.finishX > this.startA) ? (this.finishX - this.startA) :  this.startA - this.finishX;
        this.duration = durationY + durationX;
    }

    public int getStartA() {
        return startA;
    }

    public void setStartA(int startA) {
        this.startA = startA;
    }

    public int getStartB() {
        return startB;
    }

    public void setStartB(int startB) {
        this.startB = startB;
    }

    public int getFinishX() {
        return finishX;
    }

    public void setFinishX(int finishX) {
        this.finishX = finishX;
    }

    public int getFinishY() {
        return finishY;
    }

    public void setFinishY(int finishY) {
        this.finishY = finishY;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    public int getDuration() {
        return duration;
    }

    public int getRideId() {
        return 0;
    }

    public Vehicle getAffectedVehicle() {
        return affectedVehicle;
    }

    public void setAffectedVehicle(Vehicle affectedVehicle) {
        this.affectedVehicle = affectedVehicle;
    }

    public boolean isAvailable() {
        return affectedVehicle == null;
    }
}
