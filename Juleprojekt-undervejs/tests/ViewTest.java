import org.junit.jupiter.api.Test;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;
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

class ViewTest {

    @Test
    void update() {
        String filePath = new File("").getAbsolutePath();
        View view = new View(new Controller());
        ArrayList<Media> media = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        String[] genreArray = {"Horror"};
        String[] genreArray2 = {"Action"};
        try {
            BufferedImage image = ImageIO.read(new File(filePath + "/Film - billeder/" + "The Godfather" + ".jpg"));
            BufferedImage image2 = ImageIO.read(new File(filePath + "/Serier - billeder/" + "Twin Peaks" + ".jpg"));

            Movie movie = new Movie("The Godfather","1972",genreArray, "9,2", image);
            // Twin Peaks; 1990-1991; Crime, Drama, Mystery; 8,8; 1-8, 2-22;
            Series series = new Series("Twin Peaks", "1990-1991", genreArray2,"8,8", image2, null );
            media.add(movie);
            media.add(series);
            genres.add(genreArray[0]);
            genres.add(genreArray2[0]);
            media.add(movie);
            media.add(series);
            view.runStreamingService(media, genres);
        }
        catch (IOException e) {
            System.out.println("Error");
        }

    }
}