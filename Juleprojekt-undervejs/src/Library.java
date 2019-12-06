import java.util.ArrayList;


public class Library {
    protected ArrayList<Media> library;

    public Library(ArrayList<Media> l) {
        this.library = l;
    }

    public ArrayList<Media> getAsList() {
        return library;
    }
}
