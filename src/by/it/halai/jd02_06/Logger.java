package by.it.halai.jd02_06;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class Logger {
    private static Logger sin;

    private Logger() {
    }

    public static synchronized Logger loggerError(String error) {
        if (sin == null) {
            sin = new Logger();
            sin.writeError(error);
        }
        return sin;
    }

    private void writeError(String error) {
        File file = new File(System.getProperty("user.dir") + "/src/by/it/halai/jd02_06/log.txt");
        try (FileOutputStream outFile = new FileOutputStream(file);
             BufferedWriter write = new BufferedWriter(new OutputStreamWriter(outFile))) {

            DateFormat df = DateFormat.getDateInstance();
            DateFormat tf = DateFormat.getTimeInstance();
            write.write(error);
            write.write(" - Date: ");
            write.write(df.format(new Date()) + ", time : " + tf.format(new Date()));
            System.out.println(error + " : " + df.format(new Date()) + " " + tf.format(new Date()));

        } catch (Exception ioe) {
            System.out.println("что-то пошло не так:" + ioe);
        }
    }
}
