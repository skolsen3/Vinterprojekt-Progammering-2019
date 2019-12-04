import java.util.ArrayList;


public class Library {
    protected String libraryName;
    protected ArrayList<Media> library;

    public Library(String libraryName, ArrayList<Media> l) {
        this.libraryName = libraryName;
        this.library = new ArrayList<>();
        this.library = l;

    }
    public ArrayList<Media> getAsList(){
        return library;
    }
}
