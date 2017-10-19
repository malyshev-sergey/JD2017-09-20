package by.it.mustaphin.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String line;

    void read() {
        SortData sd = new SortData();
        System.out.println("Введите команду \"sortvar\" для отображения всех результатов или команду \"printvar\" или введите команду \"Выход\" для завершения работы");
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine().trim();
        if (line.equalsIgnoreCase("sortvar")) {
            sd.sortvar();
            read();
        } else if (line.equalsIgnoreCase("Выход")) {
            System.exit(0);
        } else if (line.equalsIgnoreCase("printvar")) {
            sd.printvar();
            read();
        } else {
            Pattern action = Pattern.compile("[-=+*/]");
            Pattern member = Pattern.compile("[0-9.]+");
            Pattern name = Pattern.compile("[a-zA-Z]+");
            Matcher mat = action.matcher(line);
            List<String> actList = new ArrayList<>();
            while (mat.find()) {
                actList.add(mat.group());
            }
            mat = member.matcher(line);
            List<String> membList = new ArrayList<>();
            while (mat.find()) {
                membList.add(mat.group());
            }
            mat = name.matcher(line);
            mat.find();
            String varName = mat.group();
            if (actList.get(1).equals("+")) {

            }
            StringBuilder sb = new StringBuilder();
        }
    }

}
