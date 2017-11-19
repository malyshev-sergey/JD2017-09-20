package by.it.govor.jd_02_05;


        import java.text.DateFormat;
        import java.util.Date;
        import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        String lang= null;
        String country= null;





        if(args.length>=2) {
            lang = args[0];
            country = args[1];
            Locale locale = new Locale(lang, country);
            ResMan.INSTANCE.setLocale(locale);
        }
            NowDate date = new NowDate(lang,country);
            date.nowDate();

        System.out.println(ResMan.INSTANCE.getString(txt.HELLO));
        System.out.println(ResMan.INSTANCE.getString(txt.Bad));
        System.out.println(ResMan.INSTANCE.getString(txt.Good));

    }
}
