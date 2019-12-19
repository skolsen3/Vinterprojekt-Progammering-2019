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

/**
 * This class is responsible for loading media data and creating the corresponding media-objects.
 */
public class FileReader {
    private BufferedReader bufferedReader;
    private static String filePath = new File("").getAbsolutePath();

    // Creates BufferedReader which loads a file at the given filepath. Catches IOException in case of failure.
    // @param fileName - filepath of given file
    public FileReader(String fileName) {
        Path path = Paths.get(fileName);
        try {
            System.out.println(path);
            bufferedReader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            System.out.println("IOException: Error loading file. Make sure the .jar file is in the same folder as the media data.");
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
            //FileReader fileReaderMovie = new FileReader("C:\\Users\\Bruger\\Documents\\GitHub\\Vinterprojekt-Progammering-2019\\film.txt");
            while ((line = fileReaderMovie.getBufferedReader().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0].trim();
                String year = (info[1]).trim();
                String[] genres = info[2].split(",");
                for(int i = 0; i<genres.length; i++) {
                    genres[i] = genres[i].trim();
                }
                String rating = info[3].trim();

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
            //FileReader fileReaderSeries = new FileReader("C:\\Users\\Bruger\\Documents\\GitHub\\Vinterprojekt-Progammering-2019\\serier.txt");
            while ((line = fileReaderSeries.getBufferedReader().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0].trim();
                String year = (info[1]).trim();
                String[] genres = info[2].split(",");
                for(int i = 0; i<genres.length; i++) {
                    genres[i] = genres[i].trim();
                }
                String rating = info[3].trim();

                String[] seasonData = info[4].split(",");
                String[][] seasonAndEpisodeData = new String[seasonData.length][2];

                for (int i = 0; i < seasonData.length; i++) {
                    seasonAndEpisodeData[i] = seasonData[i].split("-");
                }

                ArrayList<Season> seasons = new ArrayList<>();
                for (int i = 0; i < seasonData.length; i++) {
                    ArrayList<Episode> episodes = new ArrayList<>();
                    for (int j = 0; j < Integer.parseInt(seasonAndEpisodeData[i][1]); j++) {
                        Episode episode = new Episode(j);
                        episodes.add(episode);
                    }
                    Season season = new Season(i + 1, episodes, Integer.parseInt(seasonAndEpisodeData[i][1]));
                    //Season constructor: int seasonNumber, ArrayList<Episode> episodes, int numberOfEpisodes
                    seasons.add(season);
                }
                try {
                    BufferedImage image = ImageIO.read(new File(filePath + "/Serier - billeder/" + name + ".jpg"));
                    Series series = new Series(name, year, genres, rating, image, seasons);
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
