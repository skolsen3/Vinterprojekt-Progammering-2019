import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * This is a class that represents a movie.
 */
public class Movie extends Media {

    /**
     * Constructor for Movie.
     * @param name          The name of the movie.
     * @param year          The release year of the movie.
     * @param genres        A String[] with the genres of the movie in each index.
     * @param rating        The rating of the movie as a String.
     * @param pictureFile   A BufferedImage of the movie poster.
     */
    public Movie(String name, String year, String[] genres, String rating, BufferedImage pictureFile) {
        super(name, year, genres, rating, pictureFile);
    }
}
