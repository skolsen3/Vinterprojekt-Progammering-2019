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
     * @param seasonNumber      The number of the season.
     * @param episodes          An ArrayList consisting of the corresponding Episode-objects of the season.
     * @param numberOfEpisodes  The number of episodes.
     */
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
