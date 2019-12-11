import java.util.ArrayList;

public class Season {
    protected int seasonNumber;
    protected ArrayList<Episode> episodes;
    protected int numberOfEpisodes;

    public Season(int seasonNumber, ArrayList<Episode> episodes, int numberOfEpisodes) {
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }
}
