package by.it.malyshev.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Runner {

    public static void main(String[] args) {

        Locale locale=Locale.getDefault();
        if (args.length >= 2) {
            String lang = args[0];
            String country = args[1];
            locale = new Locale(lang, country);
            ResMan.INSTANCE.setLocale(locale);
        }

        String inputLine;

        while (true) {
            boolean exit=false;
            System.out.print("\n"+ResMan.INSTANCE.getString(Msg.WELCOM)+", ");
            System.out.println(ResMan.INSTANCE.getString(Msg.NAME)+"!");
            System.out.println(ResMan.INSTANCE.getString(Msg.HOW_DO_YOU_DO));
            System.out.println(ResMan.INSTANCE.getString(Msg.TEST)+"\n");
            System.out.println(ResMan.INSTANCE.getDateFormat().format(new Date()));
            System.out.print("\n"+ResMan.INSTANCE.getString(Msg.COMMAND));

            inputLine = getCommandLine();
            switch (inputLine) {
                case "ru":
                    locale=new Locale("ru", "RU");
                    break;
                case "be":
                    locale=new Locale("be", "BY");
                    break;
                case "en":
                    locale=Locale.ENGLISH;
                    break;
                case "exit":
                    exit=true;
                    break;
            }
            if (exit) break;
            ResMan.INSTANCE.setLocale(locale);
        }


    } //main

    private static String getCommandLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = null;
        try {
            inputLine = br.readLine().trim().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }

} //Runner
