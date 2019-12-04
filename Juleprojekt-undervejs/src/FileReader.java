import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private InputStream stream;
    private BufferedReader br;


    public FileReader(String file) {
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        br = new BufferedReader(new InputStreamReader(stream));
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
                String[] info = line.split("; ");

                String name = info[0];
                String year = info[1];
                String[] genres = info[2].split(",");
                double rating = Double.parseDouble(info[3]);

                Movie movie = new Movie(name, year, genres, rating, true);
                media.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReaderSeries = new FileReader("C:\\Users\\Bruger\\Documents\\GitHub\\Vinterprojekt-Progammering-2019\\series.txt");
            while ((line = fileReaderSeries.getBr().readLine()) != null) {
                String[] info = line.split("; ");

                String name = info[0];
                String year = info[1];
                String[] genres = info[2].split(",");
                double rating = Double.parseDouble(info[3]);

                Series series = new Series(name, year, genres, rating, true, null);
                media.add(series);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        return media;
    }
}
