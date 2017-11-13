package by.it.ali.jd02_05;


import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        if (args.length>=2){
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            ResMng.INSTANCE.SetLocale(locale);
        }
        else
        {
            Locale locale = Locale.US;
            ResMng.INSTANCE.SetLocale(locale);
        }

        System.out.println(ResMng.INSTANCE.GetString("msg.welcome"));
        System.out.println(ResMng.INSTANCE.GetString("msg.name"));
        System.out.println(ResMng.INSTANCE.GetString("msg.hru"));
    }
}
