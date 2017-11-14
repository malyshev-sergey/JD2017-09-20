package by.it.ali.jd02_05;

import java.util.Locale;
import java.util.Scanner;

class Read {
    private Scanner sc = new Scanner(System.in);
    Locale locale = Locale.getDefault();
    protected Locale str() {
        System.out.println("Какую локаль использовать? RU, BY, EN ?");
        String strLocale = sc.nextLine();
        switch (strLocale) {
            case "RU":
                locale = new Locale("ru", "RU");
                break;
            case "BY":
                locale = new Locale("be", "BY");
                break;
            case "EN":
                locale = Locale.US;
                break;
            default:
                locale = new Locale("be", "BY");
                break;
        }
        return locale;
    }
}
