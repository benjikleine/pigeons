import java.util.Comparator;

public class SortByPoints implements Comparator<Chipring> {
    public SortByPoints() {
    }

    public int compare(Chipring a, Chipring b) {
        return (int)(b.getPoints() - a.getPoints());
    }
}
