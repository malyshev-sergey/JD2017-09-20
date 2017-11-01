package by.it.akhmelev.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    //проверка типа вынесена в метод
    private static boolean checkPattern(String pattern, String str) {
        return Pattern.compile(pattern).matcher(str).matches();
    }

    //преобразование строки в переменную
    private static Var getVar(String strVar) throws MathException {
        if (checkPattern(Patterns.exMat, strVar))
            throw new MathException("Работа с матрицами пока не реализована.");
        if (checkPattern(Patterns.exVec, strVar))
            return new VarV(strVar);
        if (checkPattern(Patterns.exVal, strVar))
            return new VarD(strVar);
        throw new MathException("Выражение не распознано");
    }

    //разбор выражения
    static void calc(String expr) {
        try {
            String operads[] = expr.split(Patterns.exOper, 2);
            String operation = "";
            Matcher m = Pattern.compile(Patterns.exOper).matcher(expr);
            if (m.find())
                operation = m.group();
            Var two = getVar(operads[1]);
            if (operation.equals("=")) {
                Var.saveVar(operads[0], two);
                System.out.println(operads[0] + "=" + two);

            } else {
                Var one = getVar(operads[0]);
                Var result = null;
                switch (operation) {
                    case "+":
                        result = one.add(two);
                        break;
                    case "-":
                        result = one.sub(two);
                        break;
                    case "*":
                        result = one.mul(two);
                        break;
                    case "/":
                        result = one.div(two);
                        break;
                }

                System.out.println(expr + "=" + result);
            }
        } catch (MathException e) {
            System.out.flush();
            System.out.println(expr+" "+e.getMessage());
        }
    }
}
