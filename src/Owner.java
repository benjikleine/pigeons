import java.util.ArrayList;

public class Owner {

    private ArrayList<Pigeon> pigeons = new ArrayList<>();
    private String name;
    private String city;
    private String telNumber;
    private String task;
    private String email;
    private double coordinates;
    private double leaderboardPoints;

    public Owner(String name, String city, String telNumber, String task, String email, double coordinates) {
        this.name = name;
        this.city = city;
        this.telNumber = telNumber;
        this.task = task;
        this.email = email;
        this.coordinates = coordinates;
    }

    public String getName() { return this.name; }

    public double getCoordinates() {return this.coordinates; }

    public double getLeaderboardPoints() { return this.leaderboardPoints; }

    public void  resetLeaderboardPoints() { this.leaderboardPoints = 0.0D; }

    public void setLeaderboardPoints(double leaderboardPoints) { this.leaderboardPoints += leaderboardPoints; }

    public void addPigeon(Pigeon pigeon) { this.pigeons.add(pigeon); }

}
