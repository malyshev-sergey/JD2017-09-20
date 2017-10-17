package by.it.mustaphin.calc;

import java.util.Scanner;

public class Parser {

    private String line;

    void parse() {
        StoreData sd = new StoreData();
        System.out.println("Введите команду \"sortvar\" для отображения всех результатов или команду \"printvar\" или введите команду \"Выход\" для завершения работы");
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine().trim();
        if (line.equalsIgnoreCase("sortvar")) {
            sd.sortvar();
            parse();
        } else if (line.equalsIgnoreCase("Выход")) {
            System.exit(0);
        } else if (line.equalsIgnoreCase("printvar")) {
            sd.printvar();
            parse();
        }
    }

}
