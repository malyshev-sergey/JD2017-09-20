package by.it.meshchenko.calc;

import by.it.meshchenko.calc.Report.FullReportBuilder;
import by.it.meshchenko.calc.Report.ShortReportBuilder;

public class CalcErrorException extends Exception {
    // Создаём Logger
    static Logger log = Logger.getInstance();

    public CalcErrorException() {
        super();
    }

    public CalcErrorException(String msg) {
        System.out.println(msg);
        log.message(msg);
        //Формирование отчёта 'полного'
        FullReportBuilder.report.append(msg + "\n");
        //Формирование отчёта 'краткого'
        ShortReportBuilder.report.append(msg + "\n");
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
