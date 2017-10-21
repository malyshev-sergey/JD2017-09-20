package by.it.mustaphin.jd01_13;

public class MyExceptioin extends Exception {

    public MyExceptioin() {
        super();
    }

    public MyExceptioin(String message) {
        super(message);
    }

    public MyExceptioin(String message, Throwable cause) {
        super(message, cause);
    }

    public MyExceptioin(Throwable cause) {
        super(cause);
    }

    protected MyExceptioin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
