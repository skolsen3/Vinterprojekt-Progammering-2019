import java.util.ArrayList;
import java.util.Arrays;

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




        System.out.println(s.sortByCategory("Crime").get(0).getName());


        String[] errorSoon = new String[2];
        errorSoon[0] = "foo";
        errorSoon[1] = "bar";
        String str = Arrays.toString(errorSoon);
        System.out.println(str);

    }

}
