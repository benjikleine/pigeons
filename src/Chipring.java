public class Chipring {
    private String ringNumber;
    private Pigeon pigeon;
    private Match match;
    private double distance;
    private double endTime;
    private double flownTime;
    private double avgSpeed;
    private double points;

    public Chipring(String ringNumber,Pigeon pigeon, Match match) {
        this.ringNumber = ringNumber;
        this.pigeon = pigeon;
        this.match = match;
        this.distance = this.getMatchCoordinates() - this.getOwnerCoordinates();
        this.match.addChipring(this);
    }

    public Pigeon getPigeon() { return this.pigeon; }

    public Owner getPigeonOwner() { return this.pigeon.getOwner(); }

    public Match getMatch() { return this.match; }

    public double getDistance() { return this.distance; }

    public double getFlownTime() { return this.flownTime; }

    public double getAvgSpeed() { return this.avgSpeed; }

    public  double getPoints() { return this.points; }

    public String getPigeonName() { return this.getPigeon().getName(); }

    public int getPigeonYear() { return this.getPigeon().getYear(); }

    public double getOwnerCoordinates() { return this.getPigeon().getOwner().getCoordinates(); }

    public double getMatchCoordinates() { return this.match.getCoordinates(); }

    public void  setEndTime(double endTime) {
        this.endTime = endTime;
        this.flownTime = endTime - this.match.getStartTime();
        this.avgSpeed = this.getDistance() / this.getFlownTime() * 60.0D;
        this.match.calculatePointsAndSort();
    }

    public void setPoints(double points) { this.points = points; }

    public void setPigeonPoints(double points) { this.getPigeon().setLeaderboardPoints(points); }

    public void setOwnerPoints(double points) { this.getPigeon().getOwner().setLeaderboardPoints(points); }

}
