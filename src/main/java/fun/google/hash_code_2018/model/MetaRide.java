package fun.google.hash_code_2018.model;

public class MetaRide extends Ride {
    private Ride ride1;
    private Ride ride2;

    public MetaRide(Ride ride1, Ride ride2) {
        super(ride1.getStartA(), ride1.getStartB(), ride2.getFinishX(), ride2.getFinishY(), ride1.getEarliestStart(), ride2.getLatestFinish());
        this.ride1 = ride1;
        this.ride2 = ride2;
    }

    @Override
    public int getDuration() {
        int durationY = (ride1.finishY > ride2.startB) ? (ride1.finishY - ride2.startB) : ride2.startB - ride1.finishY;
        int durationX = (ride1.finishX > ride2.startA) ? (ride1.finishX - ride2.startA) : ride2.startA - ride1.finishX;
        int timeBetweenRide = durationY + durationX;
        return ride1.getDuration() + ride2.getDuration() + timeBetweenRide;
    }

    @Override
    public String displayRideId() {
        return ride1.displayRideId() + " " + ride2.displayRideId();
    }

    @Override
    public int getSize() {
        return 2;
    }
}
