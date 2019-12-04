import java.util.ArrayList;

public class Series extends Media {

    protected ArrayList<Season> seasons;

    public Series(String name, String year, String[] genres, String rating, ArrayList<Season> seasons) {
        super(name, year, genres, rating);
        this.seasons = seasons;
    }
}
