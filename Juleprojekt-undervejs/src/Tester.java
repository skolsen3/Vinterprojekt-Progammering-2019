import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
         new Controller();

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

        ArrayList<String> a1 = new ArrayList();
        a1.add("Crime");
        System.out.println(s.sortByCategory(a1).get(0).getName());


        String[] errorSoon = new String[2];
        errorSoon[0] = "foo";
        errorSoon[1] = "bar";
        String str = Arrays.toString(errorSoon);
        System.out.println(str);


        ArrayList<String> a2= new ArrayList();
        a2.add("Crime");
        a2.add("Drama");
        for (int i = 0; i < 5; i++) {
            System.out.println(s.sortByCategory(a2).get(i).getName());
        }

    }

}
