/**
 * This is a class for a runtime exception that is thrown when no media matches a user's search.
 */
public class NoSuchMediaException extends RuntimeException {

    protected String mediaName;

    /**
     * Constructor of the exception.
     * @param mediaName
     */
    public NoSuchMediaException(String mediaName) {
        super("No media matches your search-criteria");
        this.mediaName = mediaName;
    }
}
