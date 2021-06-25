import java.util.Comparator;

public class OwnerLeaderBoardByPoints implements Comparator<Owner> {
    public OwnerLeaderBoardByPoints() {
    }

    public int compare(Owner a, Owner b) { return (int)(b.getLeaderboardPoints() - a.getLeaderboardPoints()); }
}
