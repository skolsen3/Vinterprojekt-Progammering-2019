import java.util.ArrayList;


public class Library {
    protected ArrayList<Media> library;

    public Library(ArrayList<Media> library) {
        this.library = library;
    }

    public ArrayList<Media> getAsList() {
        return library;
    }


}
