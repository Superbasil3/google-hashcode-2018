package fun.google.hash_code_2018.model;

public class Ride {
    private int startA;
    private int startB;
    private int finishX;
    private int finishY;
    private int earliestStart;
    private int latestFinish;

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
}