public class Pigeon {

    private String name;
    private String sex;
    private  Owner owner;
    private String ownerRing;
    private int year;
    private double leaderboardPoints;

    public Pigeon(String name, String sex, String ownerRing, Owner owner, int year) {
        this.name = name;
        this.sex = sex;
        this.ownerRing = ownerRing;
        this.owner = owner;
        this.year = year;
        this.owner.addPigeon(this);
    }

    public String getName() { return this.name; }

    public int getYear() { return this.year; }

    public Owner getOwner() { return this.owner; }

    public double getLeaderboardPoints() { return this.leaderboardPoints; }

    public void  resetLeaderboardPoints() { this.leaderboardPoints = 0.0D; }

    public void setLeaderboardPoints(double leaderboardPoints) { this.leaderboardPoints += leaderboardPoints; }
}
