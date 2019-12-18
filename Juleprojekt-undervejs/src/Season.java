import java.util.ArrayList;

/**
 * This is a class to respresent a season of a series.
 */
public class Season {
    protected int seasonNumber;
    protected ArrayList<Episode> episodes;
    protected int numberOfEpisodes;

    /**
     * Constructor of season.
     * @param seasonNumber
     * @param episodes
     * @param numberOfEpisodes
     */
    public Season(int seasonNumber, ArrayList<Episode> episodes, int numberOfEpisodes) {
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    /**
     * @param episode
     */
    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    /**
     * @param episodes
     */
    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    /**
     * @return numberOfEpisodes.
     */
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    /**
     * @return seasonNumber.
     */
    public int getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * @return episodes.
     */
    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }
}
