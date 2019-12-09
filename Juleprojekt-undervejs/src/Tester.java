

public class Tester {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        View view = new View();

        view.run(searchEngine.getLibrary(), searchEngine.getGenreList());
    }
}
