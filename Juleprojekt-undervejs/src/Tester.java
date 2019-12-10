import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        SearchEngine s = new SearchEngine();

        System.out.println(s.getLibrary().size());

        for (int i = 0; i < 10; i++) {
            System.out.println(s.getGenreList().get(i));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(s.sortByName("the").get(i).getName());
        }

        s.resetMedia();
        System.out.println(s.getLibrary().size());


        ArrayList<String> a = new ArrayList();
        System.out.println(a.isEmpty());


        System.out.println(s.sortByCategory(s.getGenreList().get(0)).isEmpty());

    }

}
