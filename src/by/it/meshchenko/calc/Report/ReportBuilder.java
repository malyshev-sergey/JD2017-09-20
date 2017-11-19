package by.it.meshchenko.calc.Report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class ReportBuilder {

    public static String timeStart;
    public static String timeEnd;

    abstract String header();
    abstract String body();
    abstract String getTimeStart();
    abstract String getTimeEnd();

    public static void setTimeStart(){
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        timeStart = formatter.format(date);
    }

    public static void setTimeEnd(){
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        timeEnd = formatter.format(date);
    }
}
