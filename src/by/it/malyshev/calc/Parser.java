package by.it.malyshev.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Parser implements Callable<String> {

    private List<String> operands;
    private List<String> operations;
    private final List<String> prior = new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));
    private String expr;
    private boolean debugOn;

    public Parser(String expression, Debug debugStatus) {
        this.expr = expression;
        this.debugOn = debugStatus == Debug.ON;
    }

    public Parser(String expression) {
        this(expression, Debug.OFF);
    }

    enum Debug {
        ON, OFF
    }


    @Override
    public String call() throws Exception {
        Var res = calc(expr);
        if (res == null) return null;
        return res.toString();
    }

    private VarCreator getVarCreator(String strVar) {
        VarCreator varCreator = null;
        if (strVar.matches(Patterns.exMat))
            varCreator = new VarCreatorVarM();
        if (strVar.matches(Patterns.exVec))
            varCreator = new VarCreatorVarV();
        if (strVar.matches(Patterns.exVal))
            varCreator = new VarCreatorVarD();
        return varCreator;
    }

    private Var getVar(String str) {
        Var res;
        VarCreator varCreator = getVarCreator(str);
        if (varCreator != null) {
            res = varCreator.factoryMethod(str);
        } else
            res = Var.getVar(str);
        return res;
    }


    Var getVarTest(String strVar) {
        return getVar(strVar);
    }


    private int getPositionOperation() {
        int currentPrior = -1;
        int currentPosition = -1;
        for (int i = 0; i < operations.size(); i++) {
            String currentOperation = operations.get(i);
            if (currentPrior < prior.indexOf(currentOperation)) {
                currentPosition = i;
                currentPrior = prior.indexOf(currentOperation);
            }
        }
        return currentPosition;
    }


    Var calc(String expr) {
        Var result = null;
        try {
            if (expr.trim().matches(Patterns.exAny)) return getVar(expr);

            List<String> test = new ArrayList<>(Arrays.asList(expr.split("=")));
            if (test.size() > 1) {
                if (!test.get(0).matches(Patterns.exVar))
                    throw new CalcError("Недопустимое имя переменной " + test.get(0));
                if (test.size() > 2) throw new CalcError("Неизвестное выражение " + expr);
            }
            operands = new ArrayList<>(Arrays.asList(expr.split(Patterns.exOper)));
            Matcher m = Pattern.compile(Patterns.exOper).matcher(expr);
            operations = new ArrayList<>();
            while (m.find())
                operations.add(m.group());
            if (operands.size() != operations.size() + 1) throw new CalcError("Неизвестное выражение " + expr);
            if (debugOn) System.out.printf("\tDEBUG: %s operand=%s operation=%s\n", expr, operands, operations);
            while (operations.size() > 0) {
                if (debugOn) debug();
                int currentPosition = getPositionOperation();
                String strOne = operands.get(currentPosition);
                String operation = operations.remove(currentPosition);
                String strTwo = operands.remove(currentPosition + 1);
                Var one = getVar(strOne.trim());
                Var two = getVar(strTwo.trim());
                if (operation.equals("=") && two != null) {
                    two.saveVar(strOne.trim());
                    return two;
                }
                if (one == null)
                    throw new CalcError("Неизвестное значение " + strOne.trim());
                if (two == null)
                    throw new CalcError("Неизвеcтное значение " + strTwo.trim());
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
                operands.set(currentPosition, result != null ? result.toString() : null);
            }
            if (result == null) throw new CalcError("Неизвестное выражение " + expr);
        } catch (ArithmeticException | CalcError e) {
            System.out.flush();
            if (!Depository.block) {
                System.out.println("Out: " + e.getMessage());
                Logger.getLogger().logWrite("Out: " + e.getMessage());
                Depository.outputLines.add(e.getMessage());
            }
        }
        return result;
    }

    private void debug() {
        StringBuilder sb = new StringBuilder("\t\tdebug: " + operands.get(0));
        for (int i = 0; i < operations.size(); i++) {
            sb.append(operations.get(i)).append(operands.get(i + 1));
        }
        System.out.println(sb.toString());
    }

}
