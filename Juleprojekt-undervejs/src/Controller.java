import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Controller {
    protected SearchEngine searchEngine;
    protected View view;

    /**
     * Initializes a new instance of a Controller,
     * The Controller instantiates a SearchEngine and a view and assign them to it's fields.
     * Then the controller runs the method run in View, with parameters from SearchEngine
     */
    public Controller() {
        searchEngine = new SearchEngine();
        view = new View(this);
        view.run(searchEngine.getLibrary(), searchEngine.getGenreList());
    }

    /**
     * Gets the list of checkboxes from View
     * It runs through the list and makes a new list containing text of all checked checkboxes
     * Tries to call view.update() with parameter gained by calling a method
     * in SearchEngine with the recently list of checked genres
     * Should the list be empty it will receive an Exception from SearchEngine and
     * show all Media instead of none.
     */
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

    /**
     * Tries to call view.update() with a list of Media,
     * The list is retrieved by a method in searchEngine with search-parameter retrieved from View
     * Should the list be empty it will notify the user and display all Media instead of none.
     */
    public void searchForString() {
        try {
            view.update(searchEngine.sortByName(view.getSearchField()));
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException(n);
            view.update(searchEngine.originalLibrary);
        }
    }

    /**
     * Sets the viewState of SearchEngine to 0 so that is knows that the user
     * is currently looking at all Media.
     * Tries to call view.update() with the entire library retrieved from SearchEngine
     * Should the library be empty it will notify the user.
     */
    public void displayAllMedia() {
        searchEngine.setViewState(0);
        try {
            view.update(searchEngine.originalLibrary);
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException(n);
            view.update(searchEngine.originalLibrary);
        }
    }

    /**
     * Sets the viewState of SearchEngine to 1 so that is knows that the user
     * is currently looking at all Series.
     * Tries to call view.update() with the all Series retrieved from SearchEngine
     * Should the library be empty it will notify the user and
     * try to show the entire Library instead.
     */
    public void showSeries() {
        searchEngine.setViewState(1);
        try {
            view.update(searchEngine.sortByTypeOfMedia("Series"));
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException(n);
            view.update(searchEngine.originalLibrary);
        }
    }
    /**
     * Sets the viewState of SearchEngine to 2 so that is knows that the user
     * is currently looking at all Media of type Movie.
     * Tries to call view.update() with the all Media of type Movie retrieved from SearchEngine
     * Should the library be empty it will notify the user and
     * try to show the entire Library instead.
     */
    public void showMovies() {
        searchEngine.setViewState(2);
        try {
            view.update(searchEngine.sortByTypeOfMedia("Movie"));
        } catch (NoSuchMediaException n) {
            System.out.println(n);
            view.displayNoSuchMovieException(n);
            view.update(searchEngine.originalLibrary);
        }
    }

    /**
     * Requests searchEngine to add m to myList
     * @param m The Media that must be added to myList
     */
    public void addToMyList(Media m) {
        searchEngine.addToMyList(m);
    }

    /**
     * Requests searchEngine to remove m from myList
     * @param m The Media that must be removed from myList
     */
    public void removeFromMyList(Media m) {
        searchEngine.removeFromMyList(m);
    }

    /**
     * Tries to call view.update() with the myList retrieved from SearchEngine
     */
    public void displayMyList() {

            view.update(searchEngine.getMyList());

    }

    /**
     * Clears the library in SearchEngine and calls the displayAllMedia() method
     */
    public void clearSearch() {
        searchEngine.resetMedia();
        displayAllMedia();
    }
}

