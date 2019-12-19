/**
 * A checked exception meant to be thrown when the username and/or password is invalid at the login screen.
 */

public class WrongLoginCredentialsException extends Exception {
    public WrongLoginCredentialsException() {
        super("Wrong username or password.");
    }
}
