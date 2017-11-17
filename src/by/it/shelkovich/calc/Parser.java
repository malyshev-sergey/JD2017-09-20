package by.it.shelkovich.calc;

import by.it.shelkovich.calc.interfaces.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Callable<Var> {


    List<String> operadns;
    List<String> operations;
    private final List<String> prior = new ArrayList<>(Arrays.asList(
            new String[]{"=", "+", "-", "*", "/"})
    );
    private String sourceStr;


    public Parser() {

    }

    public Parser(String source) {
        sourceStr = source;
    }


    public Var exeOp(String operation) {
        Pattern p = Pattern.compile(Patterns.exFull);
        Matcher m = p.matcher(operation);

        if (m.matches()) {
            VarFactory factory = VarFactory.getInstance();
            String op = m.group("op");
            switch (op) {
                case "+":
                    return factory.getVar(m.group("first")).add(factory.getVar(m.group("second")));
                case "-":
                    return factory.getVar(m.group("first")).sub(factory.getVar(m.group("second")));
                case "*":
                    return factory.getVar(m.group("first")).mul(factory.getVar(m.group("second")));
                case "/":
                    return factory.getVar(m.group("first")).div(factory.getVar(m.group("second")));
                case "=":
                    return factory.getVar(m.group("first")).set(factory.getVar(m.group("second")));
            }
        }
        return null;
    }

    public Var calc(String calcString) {
        List<String> subBracers = getSubBracersList(calcString);
        if (subBracers.size() > 0) {
            List<FutureTask<Var>> tasks = new ArrayList<>();
            ExecutorService executor = Executors.newFixedThreadPool(subBracers.size());

            for (int i = 0; i < subBracers.size(); i++) {
                Callable<Var> parser = new Parser(subBracers.get(i));
                FutureTask<Var> fTask = new FutureTask<Var>(parser);
                tasks.add(fTask);
                calcString = calcString.replace("(" + subBracers.get(i) + ")", "#" + tasks.indexOf(fTask) + "$");
                executor.execute(fTask);
            }
            executor.shutdown();

            while (true) {
                boolean exit = true;
                for (FutureTask<Var> task : tasks) {
                    if (task.isDone()) {
                        try {
                            calcString = calcString.replace("#" + tasks.indexOf(task) + "$", task.get().toString());
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    } else {
                        exit = false;
                    }
                }
                if (exit) break;
            }
        }

        operations = new ArrayList<>();
        Var result = null;
        operadns = new ArrayList<>(Arrays.asList(calcString.split(Patterns.exOper)));
        Pattern pattern = Pattern.compile(Patterns.exOper);
        Matcher matcher = pattern.matcher(calcString);
        while (matcher.find()) operations.add(matcher.group());

        while (operations.size() > 0) {
            int nextOp = getNextOpPosition();
            String operation = operations.remove(nextOp);
            String left = operadns.get(nextOp);
            String right = operadns.remove(nextOp + 1);
            result = exeOp(left + operation + right);
            operadns.set(nextOp, result.toString());
            //debug();
        }
        return result;
    }

    private int getNextOpPosition() {
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

    private List<String> getSubBracersList(String calcString) {
        List<String> result = new ArrayList<>();
        while (calcString.contains("(")) {
            char[] chars = calcString.toCharArray();
            int openBracerCount = 1;
            int closeBracerPos = -1;
            for (int i = calcString.indexOf("(") + 1; i < chars.length; i++) {
                if (chars[i] == '(') openBracerCount++;
                if (chars[i] == ')') {
                    openBracerCount--;
                    if (openBracerCount == 0) {
                        closeBracerPos = i;
                        break;
                    }
                }
            }
            String entry = calcString.substring(calcString.indexOf("(") + 1, closeBracerPos);
            result.add(entry);
            calcString = calcString.replace("(" + entry + ")", "");
        }
        return result;
    }

    @Override
    public Var call() throws Exception {
        if (sourceStr != null) return calc(sourceStr);
        else return null;
    }
}

