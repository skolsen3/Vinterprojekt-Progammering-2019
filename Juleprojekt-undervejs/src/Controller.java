import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Controller {
    protected SearchEngine searchEngine;
    protected View view;


    public Controller() {
        searchEngine = new SearchEngine();
        view = new View(this);
        view.run(searchEngine.getLibrary(), searchEngine.getGenreList());
    }

    public void searchByGenre() {
        ArrayList<String> tempListOfGenres = new ArrayList<>();
        ArrayList<JCheckBox> tempListOfCheckBoxes = view.getJCheckBoxArrayList();
        for (JCheckBox jCheckBox : tempListOfCheckBoxes) {
            if (jCheckBox.isSelected()) {
                tempListOfGenres.add(jCheckBox.getText());

            }
        }
        try {

            view.update(searchEngine.sortByCategory(tempListOfGenres));
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.update(searchEngine.originalLibrary);
        }
    }


}

