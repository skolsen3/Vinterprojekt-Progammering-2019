import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controller {
    protected SearchEngine searchEngine;
    protected View view;

    public Controller(){
        SearchEngine searchEngine = new SearchEngine();
        View view = new View(this);
        view.run(searchEngine.getLibrary(),searchEngine.getGenreList());
    }

    public void searchByGenre() {
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
        view.update(searchEngine.getLibrary());
    }
    public void searchByGenre2(){
        view.update(searchEngine.getLibrary());
    }



}
