import java.util.Comparator;

public class SortByAvgSpeed implements Comparator<Chipring> {
    public SortByAvgSpeed() {
    }

    public int compare(Chipring a, Chipring b) {
        return (int)(b.getAvgSpeed() - a.getAvgSpeed());
    }
}
