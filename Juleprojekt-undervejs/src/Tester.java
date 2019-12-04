import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Media> a = (ArrayList<Media>) FileReader.readMedia();
        System.out.println(a.get(0).getName());
        System.out.println(a.get(0).getYear());
        System.out.println(a.get(0).getRating());
    }
}
