package utils.exceptions;

public class InvalidTextException extends Exception {
    public InvalidTextException() {}

    public InvalidTextException(String msg) {
        super(msg);
    }
}