package by.it.shelkovich.jd2_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner2_05 {
    public static void main(String[] args) {
        DateFormat df;
        if(args.length>=2){
            Locale locale = new Locale(args[0],args[1]);
            ResMan.INSTANCE.changeResource(locale);
            df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        } else {
            df = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
        }

        System.out.println(df.format(new Date()));
        System.out.println(ResMan.INSTANCE.getString(Msg.WELCOME));
        System.out.println(ResMan.INSTANCE.getString(Msg.NAME));
        System.out.println(ResMan.INSTANCE.getString(Msg.WHAT_A_LONELY_DAY));

        Text2PropConverter converter = new Text2PropConverter();
        converter.convert("test_be_BY.txt");

        Scanner scanner = new Scanner(System.in);

        out: while(true){
            System.out.println(ResMan.INSTANCE.getString(Msg.NEXT_LINE));
            String command = scanner.nextLine();
            Locale locale = null;
            switch (command){
                case "ru":
                     locale = new Locale("ru","BY");
                     break;
                case "be":
                    locale = new Locale("be","BY");
                    break;
                case "en":
                    locale = new Locale("en","US");
                    break;
                case "exit":
                    break out;
            }
            if (locale != null){
                ResMan.INSTANCE.changeResource(locale);
                df = DateFormat.getDateInstance(DateFormat.FULL, locale);
            }
            System.out.println(df.format(new Date()));
            System.out.println(ResMan.INSTANCE.getString(Msg.WELCOME));
            System.out.println(ResMan.INSTANCE.getString(Msg.NAME));
            System.out.println(ResMan.INSTANCE.getString(Msg.WHAT_A_LONELY_DAY));
        }
    }
}
