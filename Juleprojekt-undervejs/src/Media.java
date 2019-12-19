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
     * @param name          The title of the media.
     * @param year          The release year of the media.
     * @param genres        A String[] with the genres of the media in each index.
     * @param rating        The rating of the media as a String.
     * @param pictureFile   A BufferedImage of the media's poster.
     */
    public Media(String name, String year, String[] genres, String rating, BufferedImage pictureFile) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.pictureFile = pictureFile;
    }


    public String getName() {
        return name;
    }


    public String getYear() {
        return year;
    }


    public String[] getGenres() {
        return genres;
    }


    public String getRating() {
        return rating;
    }


    public BufferedImage getPictureFile() {
        return pictureFile;
    }
}

