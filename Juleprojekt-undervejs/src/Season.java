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

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
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
