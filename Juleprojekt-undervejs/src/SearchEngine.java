import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngine {
    protected ArrayList<Media> library;
    protected ArrayList<Media> originalLibrary;
    protected ArrayList<String> genreList;
    protected ArrayList<Media> myList;

    public SearchEngine() {
        library = FileReader.readMedia().get(0);
        originalLibrary = library;
        genreList = FileReader.readMedia().get(1);
    }

    public ArrayList<Media> getLibrary() {
        return library;
    }

    public void resetMedia() {
        library = originalLibrary;
    }

    public ArrayList<String> getGenreList() {
        return genreList;
    }

    public void clearLibrary() {
        library = new ArrayList();
    }

    public ArrayList<Media> sortByName(String s) {
        clearLibrary();
        for (Media m : originalLibrary) {
            if (m.getName().toLowerCase().contains(s)) {
                library.add(m);
            }

        }
        if (library.isEmpty()) {
            throw new NoSuchMediaException(s);
        } else {
            return library;
        }
    }

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
        if (library.isEmpty()) {
            throw new NoSuchMediaException("LegalString");
        } else {
            return library;
        }
    }


    public ArrayList<Media> sortByTypeOfMedia(String typeOfMedia) {
        ArrayList<Media> tempList = new ArrayList<>();

        if (typeOfMedia.contains("Movie")) {
            for (Media m : library) {
                if (m instanceof Movie) {
                    tempList.add(m);
                }
            }
        }
        if (typeOfMedia.contains("Series")) {
            for (Media m : library) {
                if (m instanceof Series) {
                    tempList.add(m);
                }
            }
        }
        return tempList;
    }

    public void addToMyList(Media m) {
        if (!myList.contains(m))
            myList.add(m);
    }

    public void removeFromMyList(Media m) {
        if (!myList.contains(m))
            myList.remove(m);
    }

    public ArrayList<Media> getMyList(){ return myList; }

}