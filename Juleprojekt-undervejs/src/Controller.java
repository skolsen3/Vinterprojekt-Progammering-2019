import java.util.ArrayList;


public class Controller {
    protected SearchEngine searchEngine = new SearchEngine();
    protected View view = new View();

    public ArrayList<Media> searchByGenre() {
        ArrayList<String> tempListOfGenres = new ArrayList();
        GUIFællesPrototype1.getJCheckBox();

        for (String currentGenre : tempListOfGenres) {
            searchEngine.sortByCategory(currentGenre);
        }
        return searchEngine.getLibrary();



    }



}
