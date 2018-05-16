package hr.hackaton.codebandits;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
