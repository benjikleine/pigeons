import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Match {
    private ArrayList<Chipring> chiprings = new ArrayList();
    private final double coordinates;
    private final double startTime;
    private final String city;
    private final int season;
    private Leaderbord leaderbord;
    private final String flightType;

    public Match(double coordinates, double startTime, String city, int season,
                 Leaderbord leaderbord, String flightType) {
        this.coordinates = coordinates;
        this.startTime = startTime;
        this.city = city;
        this.season = season;
        this.leaderbord = leaderbord;
        this.flightType = flightType;
        this.addMatchToLeaderbord(this);
    }

    public ArrayList<Chipring> getChiprings() {
        return this.chiprings;
    }

    public double getCoordinates() {
        return this.coordinates;
    }

    public double getStartTime() {
        return this.startTime;
    }

    public String getFlightType() {
        return this.flightType;
    }

    public void addChipring(Chipring chipring) {
        if (this.flightType == "jonge duiven" && chipring.getPigeonYear() != this.season) {
            System.out.println(chipring.getPigeonName() + " is too old to compete in this race!");
        } else {
            this.chiprings.add(chipring);
        }

    }

    public void addMatchToLeaderbord(Match match) {
        if (this.season == this.leaderbord.getSeason()) {
            this.leaderbord.getMatches().add(match);
        }

    }

    public void calculatePointsAndSort() {
        for(int i = 0; i < this.chiprings.size(); ++i) {
            Collections.sort(this.chiprings, new SortByAvgSpeed());
        }

        Iterator var3 = this.chiprings.iterator();

        while(var3.hasNext()) {
            Chipring c = (Chipring)var3.next();
            c.setPoints(c.getDistance() / 100.0D + (double)this.chiprings.size() - (double)this.chiprings.indexOf(c));
        }

        Collections.sort(this.chiprings, new SortByPoints());
    }

    public void printMatchInfo() {
        String var10001 = this.city;
        System.out.println("\n\n------------ " + var10001 + " race ---------------- \n " + this.city + "\n " +
                this.flightType.substring(0, 1).toUpperCase() + this.flightType.substring(1) + "\n");

        PrintStream var10000;
        for(int i = 0; i < this.chiprings.size(); ++i) {
            var10000 = System.out;
            var10001 = ((Chipring)this.chiprings.get(i)).getPigeonName();
            var10000.println(var10001 + " flew with an average speed of: " + (int)((Chipring)
                    this.chiprings.get(i)).getAvgSpeed() + " kilometeres p/h.");
        }

        System.out.println("\n ------------ Race Results --------- ") ;
        Iterator var3 = this.chiprings.iterator();

        while(var3.hasNext()) {
            Chipring c = (Chipring)var3.next();
            var10000 = System.out;
            int var4 = this.chiprings.indexOf(c) + 1;
            var10000.println(var4 + " " + c.getPigeonName() + " got " + (int)c.getPoints() + " points.");
        }

    }
}
