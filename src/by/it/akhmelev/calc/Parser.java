package by.it.akhmelev.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static Var getVar(String strVar) throws MathException {
        if (Pattern.compile(Patterns.exMat).matcher(strVar).find()) {
            throw new MathException("Работа с матрицами пока не реализована.");
        }
        if (Pattern.compile(Patterns.exVec).matcher(strVar).find())
            return new VarV(strVar);
        if (Pattern.compile(Patterns.exVal).matcher(strVar).find())
            return new VarD(strVar);
        throw new MathException("Выражение не распознано");
    }

    static void calc(String expr) {
        try {
            String operads[] = expr.split(Patterns.exOper, 2);
            String operation = "";
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(expr);
            if (m.find())
                operation = m.group();
            Var two = getVar(operads[1]);
            if (operation.equals("=")) {
                Var.saveVar(operads[0], two);
                System.out.println(operads[0]+"="+two);

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
            System.out.println(e);
        }


    }
}
