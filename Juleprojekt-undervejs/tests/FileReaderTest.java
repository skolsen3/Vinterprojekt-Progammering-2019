import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void getBufferedReader() {
    }

    @Test
    void readMedia() {
         //public Movie(String name, String year, String[] genres, String rating, BufferedImage pictureFile)
        String[] genres = {"Crime", "Drama"};
        Movie movie = new Movie("The Godfather","1972", genres, "9,2", null);
        //The Godfather; 1972; Crime, Drama; 9,2;

        System.out.println(FileReader.readMedia().get(0)==null);
        ArrayList<Media> media = FileReader.readMedia().get(0);
        Movie godFather = (Movie) media.get(0);

        assertEquals(movie.getName(), godFather.getName());

    }
}