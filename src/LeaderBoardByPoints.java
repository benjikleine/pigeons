import java.util.Comparator;

public class LeaderBoardByPoints implements Comparator<Pigeon> {
    public LeaderBoardByPoints() {
    }

    public int compare(Pigeon a, Pigeon b) { return (int)(b.getLeaderboardPoints() - a.getLeaderboardPoints()); }
}
