public class NoSuchMediaException extends RuntimeException {
    protected String mediaName;
    public NoSuchMediaException(String mediaName) {
        super("No movies matching your search-criteria");
        this.mediaName = mediaName;
    }
}
