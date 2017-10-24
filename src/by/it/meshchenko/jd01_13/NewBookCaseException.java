package by.it.meshchenko.jd01_13;

public class NewBookCaseException extends Exception {
    public NewBookCaseException() {
    }

    public NewBookCaseException(String message) {
        super(message);
    }

    public NewBookCaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewBookCaseException(Throwable cause) {
        super(cause);
    }
}
