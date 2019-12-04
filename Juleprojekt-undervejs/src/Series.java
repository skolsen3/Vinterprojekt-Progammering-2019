import java.util.ArrayList;

public class Series extends Media {

    protected ArrayList<Season> seasons;

    public Series(String name, String year, String[] genres, double rating, boolean visible, ArrayList<Season> seasons) {
        super(name, year, genres, rating, visible);
        this.seasons = seasons;
    }
}
