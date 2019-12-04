package model;

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


    public List<Media> readMedia() {
        List<Media> pictures = new ArrayList<>();

        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] info = line.split("; ");

                String title = info[0];
                String description = info[1];

                Media m = new Media(title, description);
                media.add(m);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        return media;
    }
}
