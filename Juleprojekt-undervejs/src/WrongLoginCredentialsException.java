public class WrongLoginCredentialsException extends Exception {
    public WrongLoginCredentialsException() {
        super("Wrong username or password.");
    }
}
