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

public class FileReader {
    private BufferedReader bufferedReader;
    private String sebStationær = "C:\\Users\\sebas\\OneDrive\\Skrivebord\\Dokumenter\\GitHub\\Vinterprojekt-Progammering-2019";
    private static String filePath = new File("").getAbsolutePath();

    // Creates BufferedReader which loads a file at the given filepath. Catches IOException in case of failure.
    // @param fileName - filepath of given file
    public FileReader(String fileName) {
        Path path = Paths.get(fileName);
        try {
            bufferedReader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            System.out.println("IOException: Error loading file.");
        }
    }


    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    /*Loads the two given files of movies and series, creates the respective Movie and Series
     objects, puts the objects in a List of Media and returns them as an ArrayList.
     */
    public static ArrayList<ArrayList> readMedia() {
        ArrayList<ArrayList> tempList = new ArrayList<>();
        ArrayList<Media> media = new ArrayList<>();
        String line;
        ArrayList<String> genreList = new ArrayList<>();
        System.out.println(filePath);
        try {
            FileReader fileReaderMovie = new FileReader(filePath + "/film.txt");
            while ((line = fileReaderMovie.getBufferedReader().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0];
                String year = (info[1]).trim();
                String[] genres = info[2].split(",");
                String rating = info[3];

                try {
                    BufferedImage image = ImageIO.read(new File(filePath + "/Film - billeder/" + name + ".jpg"));
                    Movie movie = new Movie(name, year, genres, rating, image);
                    media.add(movie);
                    for (String g : genres) {
                        if (!genreList.contains(g.trim()))
                            genreList.add(g.trim());
                    }
                } catch (IOException e) {
                    e.getStackTrace();
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: Error loading file.");
        }

        try {
            FileReader fileReaderSeries = new FileReader(filePath + "/serier.txt");
            while ((line = fileReaderSeries.getBufferedReader().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0];
                String year = (info[1]).trim();
                String[] genres = info[2].split(",");
                String rating = info[3];

                try {
                    BufferedImage image = ImageIO.read(new File(filePath + "/Serier - billeder/" + name + ".jpg"));
                    Series series = new Series(name, year, genres, rating, image, null);
                    media.add(series);
                    for (String g : genres) {
                        if (!genreList.contains(g.trim()))
                            genreList.add(g.trim());
                    }
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: Error loading files.");
        }

        tempList.add(media);
        tempList.add(genreList);
        return tempList;

    }
}
