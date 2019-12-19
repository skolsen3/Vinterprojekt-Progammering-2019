import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchEngineTest {


    @Test
    void getLibrary() {
        SearchEngine s = new SearchEngine();
        assertFalse(s.getLibrary()== null);
    }

    @Test
    void resetMedia() {
    }

    @Test
    void getGenreList() {
    }

    @Test
    void clearLibrary() {
    }

    @Test
    void sortByName() {
    }






    @Test
    void sortByCategory() {
        SearchEngine searchEngine = new SearchEngine();
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Sport");

        assertEquals(searchEngine.sortByCategory(categories).get(0).getName(),"Raging Bull");
        assertEquals(searchEngine.sortByCategory(categories).get(1).getName(),"Rocky");
        assertEquals(searchEngine.sortByCategory(categories).get(2).getName(),"GLOW");
    }




























    @Test
    void sortByTypeOfMedia() {
    }

    @Test
    void addToMyList() {
    }

    @Test
    void removeFromMyList() {
    }

    @Test
    void getMyList() {
    }

    @Test
    void setViewState() {
    }
}