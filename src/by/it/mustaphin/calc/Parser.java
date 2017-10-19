package by.it.mustaphin.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    void read() {
        System.out.println("Напишите выражение или введите команду \"sortvar\" для отображения всех результатов или команду \"printvar\" или введите команду \"exit\" для выхода");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().trim();
        if (line.equalsIgnoreCase("sortvar")) {
            StoreData.sortvar();
            read();
        } else if (line.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else if (line.equalsIgnoreCase("printvar")) {
            StoreData.printvar();
            read();
        } else {
            parseExpression(line);
        }
    }

    void parseExpression(String line) {
        Pattern action = Pattern.compile("[-=+*/]");
        Pattern varsD = Pattern.compile("[0-9.]+");
        Pattern varsV = Pattern.compile("[{][0-9.,]+[}]");
        Pattern varName = Pattern.compile("[a-zA-Z]+");
        Matcher mat = action.matcher(line);
        //...
    }

    /**
     * <?extends Var> void add(Var var1, Var var2) {
     var1.add(var2);
     }
     **/
}
