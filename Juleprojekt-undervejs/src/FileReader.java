import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

public class FileReader {
    private BufferedReader bufferedReader;

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
    public static List<Media> readMedia() {
        List<Media> media = new ArrayList<>();
        String line;

        try {
            FileReader fileReaderMovie = new FileReader("C:\\Users\\Bruger\\Documents\\GitHub\\Vinterprojekt-Progammering-2019\\film.txt");
            while ((line = fileReaderMovie.getBufferedReader().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0];
                String year = info[1];
                String[] genres = info[2].split(",");
                String rating = info[3];

                Movie movie = new Movie(name, year, genres, rating);
                media.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: Error loading file.");
        }

        try {
            FileReader fileReaderSeries = new FileReader("C:\\Users\\Bruger\\Documents\\GitHub\\Vinterprojekt-Progammering-2019\\serier.txt");
            while ((line = fileReaderSeries.getBufferedReader().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0];
                String year = info[1];
                String[] genres = info[2].split(",");
                String rating = info[3];

                Series series = new Series(name, year, genres, rating, null);
                media.add(series);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: Error loading file.");
        }


        return media;
    }
}
