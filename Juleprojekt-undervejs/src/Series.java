import java.util.ArrayList;

public class Series extends Media {

    protected ArrayList<Season> seasons;

    public Series(String name, String year, double rating, String[] genres, boolean visible, ArrayList<Season> seasons) {
        super(name, year, rating, genres, visible);
        this.seasons = seasons;
    }
}
