import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The class to represent a media.
 */
public class Media {
    protected String name;
    protected String year;
    protected String[] genres;
    protected String rating;
    protected BufferedImage pictureFile;

    /**
     * This is the constructor of Media.
     * @param name
     * @param year
     * @param genres
     * @param rating
     * @param pictureFile
     */
    public Media(String name, String year, String[] genres, String rating, BufferedImage pictureFile) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.pictureFile = pictureFile;
    }

    /**
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return year.
     */
    public String getYear() {
        return year;
    }

    /**
     * @return genres.
     */
    public String[] getGenres() {
        return genres;
    }

    /**
     * @return rating.
     */
    public String getRating() {
        return rating;
    }

    /**
     * @return pictureFile.
     */
    public BufferedImage getPictureFile() {
        return pictureFile;
    }
}

