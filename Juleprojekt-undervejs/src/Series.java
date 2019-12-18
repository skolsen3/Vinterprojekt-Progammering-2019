import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * This is a class to represent a TV-series.
 */
public class Series extends Media {
    protected ArrayList<Season> seasons;

    /**
     * Constructor of Series.
     * @param name
     * @param year
     * @param genres
     * @param rating
     * @param pictureFile
     * @param seasons
     */
    public Series(String name, String year, String[] genres, String rating, BufferedImage pictureFile, ArrayList<Season> seasons) {
        super(name, year, genres, rating, pictureFile);
        this.seasons = seasons;
    }

    /**
     * @return the number of seasons a series have.
     */
    public int getNumberOfSeasons() {
        if(seasons.size() > 0) {
            return seasons.size();
        } else {
            return 0;
        }
    }

}
