package by.it.meshchenko.calc;

import java.io.IOException;

public class CalcErrorException extends Exception {
    // Создаём Logger
    static Logger log = Logger.getInstance();

    public CalcErrorException() {
        super();
    }

    public CalcErrorException(String msg) {
        System.out.println(msg);
        log.writeError(msg);
    }

    public CalcErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcErrorException(Throwable cause) {
        super(cause);
    }

    protected CalcErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
