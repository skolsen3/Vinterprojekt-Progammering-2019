import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngine {
    protected ArrayList<Media> library;
    protected ArrayList<Media> originalLibrary;
    protected ArrayList<String> genreList;
    protected ArrayList<Media> myList;
    protected int viewState;

    public SearchEngine() {
        library = FileReader.readMedia().get(0);
        originalLibrary = library;
        genreList = FileReader.readMedia().get(1);
        myList = new ArrayList<>();
    }


    /* Returns the current Library
    *  @return library An ArrayList of Media
    */
    public ArrayList<Media> getLibrary() {
        return library;
    }

    /* Resets library, such that library holds all files again*/
    public void resetMedia() {
        library = originalLibrary;
    }

    /* return a list containing all genres contained in any Media
    * @return genreList The list of genres */
    public ArrayList<String> getGenreList() {
        return genreList;
    }
    /* empties the library */
    public void clearLibrary() {
        library = new ArrayList<>();
    }

    /*
    *   Searches for a movie title matching the title given by the user.
    *   @param s The String to search for
    *   @return library The library containing Media matching s
    */
    public ArrayList<Media> sortByName(String s) {
        clearLibrary();
        for (Media m : originalLibrary) {
            if (m.getName().toLowerCase().contains(s.toLowerCase())) {
                library.add(m);
            }

        }
        if (library.isEmpty()) {
            throw new NoSuchMediaException(s);
        } else {
            return library;
        }
    }

    /*  Searches for movies matching any of the Categories given as Parameter.
    *   @param Categories An ArrayList<String> containing all categories you want to search for
    *   @return library A library containing all movies matching any of the Categories
    */
    public ArrayList<Media> sortByCategory(ArrayList<String> Categories) {
        clearLibrary();
        for (String cat : Categories) {

            for (Media m : originalLibrary) {
                String str = Arrays.toString(m.getGenres());
                if (str.contains(cat) && !library.contains(m)) {
                    library.add(m);

                }
            }
        }
        if (viewState == 1) {
            ArrayList<Media> tempList = new ArrayList<>();
            for (Media m2 : library) {
                if (!(m2 instanceof Movie)) {
                    tempList.add(m2);
                }
            }
            library = tempList;
        }
        if (viewState == 2) {
            ArrayList<Media> tempList = new ArrayList<>();
            for (Media m3 : library) {
                if (!(m3 instanceof Series)) {
                    tempList.add(m3);
                }
            }
            library = tempList;
        }
        if (library.isEmpty()) {
            throw new NoSuchMediaException("LegalString");
        } else {
            return library;
        }
    }

    /*  Searches for and returns all Media of given type.
    *   @param typeOfMedia The type of Media you want to be shown
    *   @return library The library containing Media matching typeOfMedia
    * */
    public ArrayList<Media> sortByTypeOfMedia(String typeOfMedia) {
        clearLibrary();
        if (typeOfMedia.contains("Movie")) {
            for (Media m : originalLibrary) {
                if (m instanceof Movie) {
                    library.add(m);
                }
            }
        }
        if (typeOfMedia.contains("Series")) {
            for (Media m : originalLibrary) {
                if (m instanceof Series) {
                    library.add(m);
                }
            }
        }
        return library;
    }
    /*  Adds Media to myList
    *   @param m The Media that's supposed to be added to myList
    */
    public void addToMyList(Media m) {
        if (!myList.contains(m))
            myList.add(m);
    }

    /*  Removes Media from myList
    *   @param m The Media that's supposed to be removed from myList
    * */
    public void removeFromMyList(Media m) {
        if (myList.contains(m))
            myList.remove(m);
    }

    /* @return myList
    * */
    public ArrayList<Media> getMyList() {
        return myList;
    }

    /*  Sets the viewState of the SearchEngine, so that it knows whether or not the user is
    *   currently looking at the all Media, only Movies, or only Series
    *   @param viewState The viewstate that must be set.
    * */
    public void setViewState(int viewState) {
        this.viewState = viewState;
    }
}