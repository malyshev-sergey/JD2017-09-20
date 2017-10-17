package by.it.shelkovich.calc;

import by.it.shelkovich.calc.interfaces.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static Var exeOp(String operation) {
        String args[] = operation.split(Patterns.exOper);
        Pattern p = Pattern.compile(Patterns.exOper);
        Matcher m = p.matcher(operation);
        m.find();
        String op = m.group();
        switch (op) {
            case "+":
                return getVarByString(args[0].trim()).add(getVarByString(args[1].trim()));
            case "-":
                return getVarByString(args[0].trim()).sub(getVarByString(args[1].trim()));
            case "*":
                return getVarByString(args[0].trim()).mul(getVarByString(args[1].trim()));
            case "/":
                return getVarByString(args[0].trim()).div(getVarByString(args[1].trim()));
            case "=":
                Storage.vars.put(args[0].trim(), getVarByString(args[1].trim()));
                return null;
        }
        return null;
    }

    private static Var getVarByString(String value) {
        if (value.charAt(0) != '{') {
            Pattern p = Pattern.compile(Patterns.exVal);
            if (p.matcher(value).matches()) return new VarD(value);
            else return null;
        } else if (value.charAt(1) != '{') return new VarV(value);
        else return new VarM(value);
    }

}
