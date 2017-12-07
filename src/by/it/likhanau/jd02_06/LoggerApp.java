package by.it.likhanau.jd02_06;


import java.io.BufferedReader;
import java.io.FileReader;

public class LoggerApp {
    private static LoggerApp loggerApp;

    private LoggerApp() {
    }

    public static LoggerApp getInstance() {
        if (loggerApp != null) {
            return loggerApp;
        } else {
            synchronized (LoggerApp.class) {
                loggerApp = new LoggerApp();
                return loggerApp;
            }
        }
    }

    public void logError(String message){
        IOUtil.writeInTheFile(message);
    }
}
