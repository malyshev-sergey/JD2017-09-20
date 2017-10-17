package by.it.malyshev.calc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    static Var fromString(String strSingleOperation) {
        if (!(strSingleOperation.trim().equals("printvar")) &&
                !(strSingleOperation.trim().equals("sortvar"))) {

            String[] strOperands = strSingleOperation.split(Patterns.exOper);
            if (!(strOperands.length == 1)) {
                Pattern p = Pattern.compile(Patterns.exOper);
                Matcher m = p.matcher(strSingleOperation);
                if (m.find()) {
                    switch (m.group()) {
                        case "+":
                            return selectTypeOfOperand(strOperands[0]).add(selectTypeOfOperand(strOperands[1]));
                        case "*":
                            return selectTypeOfOperand(strOperands[0]).mul(selectTypeOfOperand(strOperands[1]));
                        case "/":
                            return selectTypeOfOperand(strOperands[0]).div(selectTypeOfOperand(strOperands[1]));
                        case "=":
                            if (strOperands[1].trim().equals("null")) break;
                            variablesCollection.put(strOperands[0], selectTypeOfOperand(strOperands[1]));
                            return null;
                    }
                }
            } else {
                if (strSingleOperation.trim().contains("{")) {
                    new CalcError("Пока не реализовано");
                    return null;
                }
                String minus = "";
                if (strSingleOperation.trim().charAt(0) == '-') {
                    minus = "-";
                    strSingleOperation = strSingleOperation.trim().substring(1, strSingleOperation.length());
                }
                    String[] strOperandsMin = strSingleOperation.split("-");
                    Pattern pMin = Pattern.compile("-");
                    Matcher mMin = pMin.matcher(strSingleOperation);
                    if (mMin.find()) {
                        return selectTypeOfOperand(minus + strOperandsMin[0]).sub(selectTypeOfOperand(strOperandsMin[1]));
                    }
                }

            new CalcError("Нет такой операции");
        } else if (strSingleOperation.trim().equals("printvar")) printVar();
        else if (strSingleOperation.trim().equals("sortvar")) sortVar();
        return null;
    }


    private static Var selectTypeOfOperand(String strOperand) {
        if (strOperand.trim().length() > 2 && strOperand.trim().substring(0, 2).equals("{{"))
            return new VarM(strOperand.trim());
        else if (strOperand.trim().substring(0, 1).equals("{")) return new VarV(strOperand.trim());
        else return new VarD(strOperand.trim());
    }

    static Map<String, Var> variablesCollection = new HashMap<>();

    static void printVar() {
        System.out.println("\nКоллекция переменных");
        Iterator<Map.Entry<String, Var>> itr = variablesCollection.entrySet().iterator();
        while (itr.hasNext()) System.out.println(itr.next());

    }

    static void sortVar() {
        System.out.println("\nОтсортированная коллекция переменных");
        TreeMap<String, Var> sortedVariables = new TreeMap<>(variablesCollection);
        Iterator<Map.Entry<String, Var>> itr = sortedVariables.entrySet().iterator();
        while (itr.hasNext()) System.out.println(itr.next());

    }


}
