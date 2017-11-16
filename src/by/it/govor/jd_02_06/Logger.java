package by.it.govor.jd_02_06;


import by.it.govor.jd_01_06.Date;
import by.it.govor.jd_02_05.NowDate;

import java.io.*;
import java.text.DateFormat;
import java.util.Locale;

class Logger {
    private static Logger singleton;

    private Logger() {

    }

    public static void loggerError(String error) {
        Logger localInstance = singleton;
        if (singleton == null) {
            synchronized (Logger.class) {
                localInstance = singleton;
                if (localInstance == null) {
                    singleton = localInstance = new Logger();
                    singleton.writeError(error);
                }
            }
        }
    }

    private void writeError(String error) {
        File file = new File(System.getProperty("user.dir") + "/src/by/it/govor/jd_02_06/log.txt");
        try( FileOutputStream outFile = new FileOutputStream(file);
             BufferedWriter write = new BufferedWriter(new OutputStreamWriter(outFile)))  {

            DateFormat date = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
            write.write(error);
            write.write(" дата проишествия:");
            write.write(date.format(new java.util.Date()));
            System.out.println( error+":"+date.format(new java.util.Date()));

        } catch (Exception ioe) {
            System.out.println("что-то пошло не так:"+ioe);
        }
    }
}
