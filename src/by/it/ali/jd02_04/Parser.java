package by.it.ali.jd02_04;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;

public class Parser {
    private static boolean checkPattern(String pattern, String str) {
        return Pattern.compile(pattern).matcher(str).matches();
    }

    //преобразование строки в переменную
    private static Var getVar(String strVar){
        if (checkPattern(Patterns.exMat, strVar))
            System.err.println("Работа с матрицами пока не реализована.");
        if (checkPattern(Patterns.exVec, strVar))
            System.err.println("Работа с векторами пока не реализована.");
        if (checkPattern(Patterns.exVal, strVar))
            return new VarD(parseDouble(strVar));
      return null;
    }

    static Var pars(String str) {
        String[] mas = str.split(Patterns.exOper);
        Pattern p = Pattern.compile(Patterns.exOper);
        Matcher m = p.matcher(str);
        String ops = "";
        if (m.find())
            ops = m.group();
        Var two = getVar(mas[1]);
        Var result = null;
        if (ops.equals("=")) {
            Var.saveVar(mas[0], two);
            System.out.println(mas[0] + " = " + two);
        } else {
            if (ops.equals("+")) {
                Var one = getVar(mas[0]);
                result = one.add(two);
            } else if (ops.equals("-")) {
                Var one = getVar(mas[0]);
                result = one.sub(two);
            } else if (ops.equals("*")) {
                Var one = getVar(mas[0]);
                result = one.mul(two);
            } else if (ops.equals("/")) {
                Var one = getVar(mas[0]);
                result = one.div(two);
            }
            System.out.println(str + " = " + result);
        }
        return result;
    }

}
