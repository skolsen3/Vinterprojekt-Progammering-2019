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
}
