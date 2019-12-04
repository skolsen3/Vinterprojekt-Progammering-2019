import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class FileReader {
    private Charset charset = Charset.forName("ISO-8859-1");
    private Path path;
    private BufferedReader br;


    public FileReader(String fileName) {
        path = Paths.get(fileName);
        try {
            br = Files.newBufferedReader(path, charset);
        } catch (IOException e) {
            System.out.println("Error. IOException");
        }
    }


    public BufferedReader getBr() {
        return br;
    }


    public static List<Media> readMedia() {
        List<Media> media = new ArrayList<>();
        String line;

        try {
            FileReader fileReaderMovie = new FileReader("C:\\Users\\Bruger\\Documents\\GitHub\\Vinterprojekt-Progammering-2019\\film.txt");
            while ((line = fileReaderMovie.getBr().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0];
                String year = info[1];
                String[] genres = info[2].split(",");
                String rating = info[3];

                Movie movie = new Movie(name, year, genres, rating, true);
                media.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReaderSeries = new FileReader("C:\\Users\\Bruger\\Documents\\GitHub\\Vinterprojekt-Progammering-2019\\serier.txt");
            while ((line = fileReaderSeries.getBr().readLine()) != null) {
                String[] info = line.split(";");

                String name = info[0];
                String year = info[1];
                String[] genres = info[2].split(",");
                String rating = info[3];

                Series series = new Series(name, year, genres, rating, true, null);
                media.add(series);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return media;
    }
}
