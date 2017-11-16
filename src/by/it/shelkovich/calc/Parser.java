package by.it.shelkovich.calc;

import by.it.shelkovich.calc.interfaces.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    List<String> operadns;
    List<String> operations;
    private final List<String> prior = new ArrayList<>(Arrays.asList(
            new String[]{"=", "+", "-", "*", "/"})
    );

    public Var exeOp(String operation) {
        Pattern p = Pattern.compile(Patterns.exFull);
        Matcher m = p.matcher(operation);

        if (m.matches()) {

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
                    return getVarByString(m.group("first")).set(getVarByString(m.group("second")));
            }
        }
        return null;
    }

    public Var getVarByString(String value) {
        if (value.charAt(0) != '{') {
            Pattern p = Pattern.compile(Patterns.exVal);
            if (p.matcher(value).matches()) return new VarD(value);

            p = Pattern.compile(Patterns.exName);
            if (p.matcher(value).matches()) return new VarS(value);
            else return null;
        } else if (value.charAt(1) != '{') return new VarV(value);
        else return new VarM(value);
    }


    public Var calc(String calcString) {
        String subCalcString;
        while ((subCalcString = subBracers(calcString)) != null)
            calcString = calcString.replace("("+subCalcString+")", calc(subCalcString).toString());

        operations = new ArrayList<>();
        Var result = null;
        operadns = new ArrayList<>(Arrays.asList(calcString.split(Patterns.exOper)));
        Pattern pattern = Pattern.compile(Patterns.exOper);
        Matcher matcher = pattern.matcher(calcString);
        while (matcher.find()) operations.add(matcher.group());

        while (operations.size() > 0){
            int nextOp = getNextOpPosition();
            String operation = operations.remove(nextOp);
            String left = operadns.get(nextOp);
            String right = operadns.remove(nextOp+1);
            result = exeOp(left+operation+right);
            operadns.set(nextOp, result.toString());
            //debug();
        }
        return result;
    }

    private int getNextOpPosition(){
        int currentPrior = -1;
        int currentPos = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (currentPrior < prior.indexOf(operation)) {
                currentPrior = prior.indexOf(operation);
                currentPos = i;
            }
        }
        return currentPos;
    }

    public String subBracers(String calcString){
        if (calcString.contains("(")){
            char[] chars = calcString.toCharArray();
            int openBracerCount = 1;
            int closeBracerPos = -1;
            for (int i = calcString.indexOf("(")+1; i < chars.length; i++) {
                if(chars[i] == '(') openBracerCount++;
                if(chars[i] == ')'){
                    openBracerCount--;
                    if (openBracerCount==0){
                        closeBracerPos = i;
                        break;
                    }
                }
            }
            return calcString.substring(calcString.indexOf("(")+1, closeBracerPos);
        }
        return null;
    }

    void debug() {
        for (int i = 0; i < operations.size(); i++) {
            System.out.print(operadns.get(i));
            System.out.print(operations.get(i));
        }
        System.out.print(operadns.get(operations.size()));
        System.out.println();
    }

}
