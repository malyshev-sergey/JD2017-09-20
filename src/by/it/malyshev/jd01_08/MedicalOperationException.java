package by.it.malyshev.jd01_08;

public class MedicalOperationException extends Exception {
    public MedicalOperationException() {
    }

    public MedicalOperationException(String message) {
        super(message);
    }

    public MedicalOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicalOperationException(Throwable cause) {
        super(cause);
    }

}
