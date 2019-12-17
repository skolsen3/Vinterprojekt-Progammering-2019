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

    public void searchForString() {
        try {
            view.update(searchEngine.sortByName(view.getSearchField()));
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException();
            view.update(searchEngine.originalLibrary);
        }
    }

    public void displayAllMedia() {
        searchEngine.setViewState(0);
        try {
            view.update(searchEngine.originalLibrary);
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException();
            view.update(searchEngine.originalLibrary);
        }
    }

    public void showSeries() {
        searchEngine.setViewState(1);
        try {
            view.update(searchEngine.sortByTypeOfMedia("Series"));
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException();
            view.update(searchEngine.originalLibrary);
        }
    }

    public void showMovies() {
        searchEngine.setViewState(2);
        try {
            view.update(searchEngine.sortByTypeOfMedia("Movie"));
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException();
            view.update(searchEngine.originalLibrary);
        }
    }


    public void addToMyList(Media m) {
        searchEngine.addToMyList(m);
    }

    public void removeFromMyList(Media m) {
        searchEngine.removeFromMyList(m);
    }

    public void displayMyList() {
        try {
            view.update(searchEngine.getMyList());
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException();
            view.update(searchEngine.originalLibrary);
        }
    }


    public void clearSearch() {
        searchEngine.resetMedia();
        displayAllMedia();
    }
}

