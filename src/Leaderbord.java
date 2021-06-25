import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Leaderbord {
    private ArrayList<Match> matches = new ArrayList();
    private final ArrayList<Pigeon> pigeons = new ArrayList();
    private int season;

    public Leaderbord(int season) {
        this.season = season;
    }

    public ArrayList<Match> getMatches() {
        return this.matches;
    }

    public int getSeason() {
        return this.season;
    }

    public void addPigeons(String flightType) {
        Iterator var2 = this.matches.iterator();

        label29:
        while(var2.hasNext()) {
            Match m = (Match)var2.next();
            Iterator var4 = m.getChiprings().iterator();

            while(true) {
                Chipring c;
                do {
                    if (!var4.hasNext()) {
                        continue label29;
                    }

                    c = (Chipring)var4.next();
                } while(flightType != c.getMatch().getFlightType() && flightType != "all");

                if (!this.pigeons.contains(c.getPigeon())) {
                    this.pigeons.add(c.getPigeon());
                }
            }
        }

    }

    public void resetLeaderboard() {
        Iterator var1 = this.pigeons.iterator();

        while(var1.hasNext()) {
            Pigeon p = (Pigeon)var1.next();
            p.resetLeaderboardPoints();
            p.getOwner().resetLeaderboardPoints();
        }

        this.pigeons.clear();
    }

    public void pigeonOfTheYear(String flightType) {
        this.resetLeaderboard();
        this.addPigeons(flightType);
        Iterator var2 = this.matches.iterator();

        while(true) {
            Match m;
            do {
                if (!var2.hasNext()) {
                    this.printOutLeaderboard(flightType);
                    return;
                }

                m = (Match)var2.next();
            } while(flightType != m.getFlightType() && flightType != "all");

            Iterator var4 = m.getChiprings().iterator();

            while(var4.hasNext()) {
                Chipring c = (Chipring)var4.next();
                c.setPigeonPoints(c.getPoints());
                Collections.sort(this.pigeons, new LeaderBoardByPoints());
            }
        }
    }

    public void ownerOfTheYear() {
        ArrayList<Owner> owner = new ArrayList();
        this.resetLeaderboard();
        System.out.println("\n ---------------Owner of the Year---------------\n");
        Iterator var2 = this.matches.iterator();

        while(var2.hasNext()) {
            Match m = (Match)var2.next();

            for(Iterator var4 = m.getChiprings().iterator(); var4.hasNext(); Collections.sort
                    (owner, new OwnerLeaderBoardByPoints())) {
                Chipring c = (Chipring)var4.next();
                c.setOwnerPoints(c.getPoints());
                if (!owner.contains(c.getPigeonOwner())) {
                    owner.add(c.getPigeon().getOwner());
                }
            }
        }

        var2 = owner.iterator();

        while(var2.hasNext()) {
            Owner o = (Owner)var2.next();
            PrintStream var10000 = System.out;
            int var10001 = owner.indexOf(o) + 1;
            var10000.println(var10001 + " " + o.getName() + " " + o.getLeaderboardPoints());
        }

    }

    public void printOutLeaderboard(String flightType) {
        PrintStream var10000;
        if (flightType == "all") {
            System.out.println("\n ---------------Best Pigeon of the Year---------------\n");
        } else {
            var10000 = System.out;
            String var10001 = flightType.substring(0, 1).toUpperCase();
            var10000.println("\n ---------------Best Pigeon at " + var10001 + flightType.substring(1) +
                    " of the Year---------------\n");
        }

        Iterator var2 = this.pigeons.iterator();

        while(var2.hasNext()) {
            Pigeon p = (Pigeon)var2.next();
            var10000 = System.out;
            int var4 = this.pigeons.indexOf(p) + 1;
            var10000.println(var4 + " " + p.getName() + " " + (int)p.getLeaderboardPoints());
        }

    }
}
