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
        Pattern vars = Pattern.compile("[0-9.]+");
        Pattern varName = Pattern.compile("[a-zA-Z]+");
        Matcher mat = action.matcher(line);
        List<String> actList = new ArrayList<>();
        while (mat.find()) {
            actList.add(mat.group());
        }
        mat = varName.matcher(line);
        mat.find();
        String key = mat.group();
        List<String> membList = new ArrayList<>();
        if (!line.contains("{")) {
            mat = vars.matcher(line);
            while (mat.find()) {
                membList.add(mat.group());
            }
            switch (actList.get(1)) {
                case "+":
                    Var varD1 = new VarD(membList.get(0));
                    Var varD2 = new VarD(membList.get(1));
                    varD1.assignment(key, varD1.add(varD2));
                    break;
            }
        }
    }

}
