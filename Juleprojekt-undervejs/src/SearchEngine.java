import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngine {
    protected ArrayList<Media> library;
    protected ArrayList<Media> originalLibrary;
    protected ArrayList<String> genreList;

    public SearchEngine() {
        library = FileReader.readMedia().get(0);
        originalLibrary = library;
        genreList = FileReader.readMedia().get(1);
    }

    public ArrayList<Media> getLibrary() {
        return library;
    }

    public ArrayList<Media> resetMedia() {
        return originalLibrary;
    }

    public ArrayList<Media> sortByName(String s) {
        ArrayList<Media> tempList = new ArrayList<>();
        for (Media m : library) {
            if (m.getName().contains(s)) {
                tempList.add(m);
            }

        }
        if (tempList.get(0) == null) {
            throw new NoSuchMediaException(s);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByCategory(String category1) {
        ArrayList<Media> tempList = new ArrayList<>();
        for (Media m : library) {
            String str = Arrays.toString(m.getGenres());
            if (str.contains(category1)) {
                tempList.add(m);
            }

        }
        if (tempList.isEmpty()) {
            throw new NoSuchMediaException(category1);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByCategory(String category1, String category2) {
        ArrayList<Media> tempList = new ArrayList<>();
        for (Media m : library) {
            if (m.getGenres().toString().contains(category1) ||
                    (m.getGenres().toString().contains(category2))) {
                tempList.add(m);
            }

        }
        if (tempList.get(0) == null) {
            throw new NoSuchMediaException(category1+","+category2);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByCategory(String category1, String category2, String category3) {
        ArrayList<Media> tempList = new ArrayList<>();
        for (Media m : library) {
            if (m.getGenres().toString().contains(category1) ||
                    (m.getGenres().toString().contains(category2)) ||
                    (m.getGenres().toString().contains(category3))) {
                tempList.add(m);
            }

        }
        if (tempList.get(0) == null) {
            throw new NoSuchMediaException(category1+","+category2+","+category3);
        } else {
            return tempList;
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

    public ArrayList<String> getGenreList() {
        return genreList;
    }
}