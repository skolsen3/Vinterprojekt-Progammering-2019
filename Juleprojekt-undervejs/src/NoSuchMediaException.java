public class NoSuchMediaException extends RuntimeException {
    public NoSuchMediaException() {
        super("No movies matching your search-criteria");
    }
}
