import javax.swing.*;
import java.util.ArrayList;


public class Controller {
    protected SearchEngine searchEngine;
    protected View view;

    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        View view = new View();
        view.run(searchEngine.getLibrary(),searchEngine.getGenreList());
    }

    public ArrayList<Media> searchByGenre() {
        ArrayList<String> tempListOfGenres = new ArrayList();
        ArrayList<JCheckBox> tempListOfCheckBoxes = view.getJCheckBoxArrayList();
        for (JCheckBox jCheckBox : tempListOfCheckBoxes) {
            if (jCheckBox.isSelected()) {
                tempListOfGenres.add(jCheckBox.getText());
            }
        }
        for (String currentGenre : tempListOfGenres) {
            searchEngine.sortByCategory(currentGenre);
        }
        return searchEngine.getLibrary();
    }


}
