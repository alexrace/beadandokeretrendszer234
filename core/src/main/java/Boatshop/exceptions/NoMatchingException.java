package Boatshop.exceptions;

public class NoMatchingException extends Exception {
    public NoMatchingException() {
    }

    public NoMatchingException(String message) {
        super(message);
    }
}
