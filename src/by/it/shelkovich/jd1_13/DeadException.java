package by.it.shelkovich.jd1_13;

public class DeadException extends Exception {
    public DeadException(){ super(); }
    public DeadException(String message, Throwable exception) {
        super(message, exception);
    }
    public DeadException(String message) {
        super(message);
    }
    public DeadException(Throwable exception) {
        super(exception);
    }

}
