package by.it.shelkovich.calc;

import by.it.shelkovich.calc.interfaces.Patterns;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static Var exeOp(String operation) {
        Pattern p = Pattern.compile(Patterns.exFull);
        Matcher m = p.matcher(operation);

        if(m.matches()) {

            String op = m.group("op");
            switch (op) {
                case "+":
                    return getVarByString(m.group("first")).add(getVarByString(m.group("second")));
                case "-":
                    return getVarByString(m.group("first")).sub(getVarByString(m.group("second")));
                case "*":
                    return getVarByString(m.group("first")).mul(getVarByString(m.group("second")));
                case "/":
                    return getVarByString(m.group("first")).div(getVarByString(m.group("second")));
                case "=":
                    VarStorage.vars.put(m.group("first"), getVarByString(m.group("second")));
                    return null;
            }
        }
        return null;
    }

    public static Var getVarByString(String value) {
        if (value.charAt(0) != '{') {
            Pattern p = Pattern.compile(Patterns.exVal);
            if (p.matcher(value).matches()) return new VarD(value);
            else return null;
        } else if (value.charAt(1) != '{') return new VarV(value);
        else return new VarM(value);
    }

//    public Var calc (List<String> elements){
//
//    }

}
