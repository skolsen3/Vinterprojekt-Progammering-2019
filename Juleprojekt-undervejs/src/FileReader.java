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


    public List<Media> readMedia() {
        List<Media> media = new ArrayList<>();
        String line;

        try {
            FileReader fileReaderFilm = new FileReader("film.txt");
            while ((line = fileReaderFilm.getBr().readLine()) != null) {
                String[] info = line.split("; ");

                String name = info[0];
                String year = info[1];

                Movie movie = new Movie(title, description);
                media.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while ((line = br.readLine()) != null) {
                String[] info = line.split("; ");

                String name = info[0];
                String year = info[1];

                Media m = new Media(title, description);
                media.add(m);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        return media;
    }
}
