import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Media> a = (ArrayList<Media>) FileReader.readMedia().get(0);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getName());
            System.out.println(a.get(i).getYear());
            System.out.println(a.get(i).getRating());
            for (int j = 0; j < a.get(i).getGenres().length; j++) {
                String[] s = a.get(i).getGenres();
                System.out.println(s[j]);

            }
        }
    }
}

