package by.it.malyshev.calc;

import by.it.malyshev.calc.report.*;
import by.it.malyshev.calc.report.Writer;

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.*;

public class ConsoleRunner {

    public static void main(String[] args) {

        Depository.programStartTime = System.currentTimeMillis();
        Depository.restore();
        help();
        boolean debug = false;

        while (true) {

            System.out.print("\r\n In: > ");

            String inputLine = getCommandLine();
            String command = inputLine.trim().toLowerCase();
            switch (command) {
                case "longreport":
                    report(false);
                    System.out.println("Полный отчет записан в файл");
                    break;
                case "shortreport":
                    report(true);
                    System.out.println("Краткий отчет записан в файл");
                    break;
                case "printvar":
                    Depository.printVar();
                    break;
                case "sortvar":
                    Depository.sortVar();
                    break;
                case "examples":
                    examples(debug);
                    break;
                case "help":
                    help();
                    break;
                case "?":
                    help();
                    break;
                case "debug on":
                    debug = true;
                    System.out.println("Включен режим отладки");
                    break;
                case "debug off":
                    debug = false;
                    System.out.println("Выключен режим отладки");
                    break;
                case "exit":
                    Depository.store();
                    report(false);
                    report(true);
                    return;
                case "":
                    break;
                default:
                    print(parse(inputLine, debug));
            }
        }

    }

    private static void examples(boolean debug) {
        String[] expessions = {
                "A=2+5.3",
                "B=A*3.5",
                "B1=B+0.11*-5",
                "B2=A/2-1",
                "C=B+(A*2)",
                "D=((C-0.15)-20)/(7-5)",
                "E={2,3}*(D/2)",
                "A1=-1*0",
                "A2=2/0",
                "A3={1,2,3}*{{1,2},{1,2},{1,2}}",
                "A4={{1,2,3},{1,2,3}}*{{1,2,3},{1,2,3},{1,2,3}}",
                "F={{1,2,3},{4,5,6},{7,8,9}}*(10+5)*(-1*(-4))-(2+1-3*(12-9))",
                "G=2+5.3+1-9*8-1/6"
        };
        for (String expession : expessions) {
            System.out.println("In:" + expession);
            print(parse(expession, debug));
        }
    }

    private static void print(String v) {
        if (v != null) {
            if (!Depository.block) {
                Logger.getLogger().logWrite("Out: " + v);
                Depository.outputLines.add(v);
                System.out.println("Out: " + v);
            }
        }
    }

    private static String getCommandLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = null;
        try {
            inputLine = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }

    private static void help() {
        String help = "\r\nУчебный проект Calc\r\n\r\nВведите выражение или команду:\r\n" +
                "\"examples\" - запустить заготовленный набор выражений;\r\n" +
                "\"exit\" - завершить программу;\r\n" +
                "\"longreport\" - печатать в файл полный отчет;\r\n" +
                "\"shortreport\" - печатать в файл краткий отчет;\r\n" +
                "\"printvar\" - вывести на консоль коллекцию переменных;\r\n" +
                "\"sortvar\" - вывести на консоль отсортированную коллекцию переменных;\r\n" +
                "\"help\" или \"?\" - печатать эту подсказку;\r\n" +
                "\"debug on\" - включить режим отладки;\r\n" +
                "\"debug off\" - выключить режим отладки";
        System.out.println(help);
    }

    private static void report(boolean needShortReport) {
        Depository.programFinishTime = System.currentTimeMillis();
        Writer writer = new Writer();
        ReportBuilder reportBuilder = needShortReport ? new ShortReportBuilder() : new LongReportBuilder();
        writer.setReportBuilder(reportBuilder);
        writer.constructReport();
        Report report = writer.getReport();
        String f = needShortReport ? "shortreport.txt" : "longreport.html";
        File reportFile = new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/out/" + f);
        File repDir = new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/out");
        if (!repDir.exists())
            if (!repDir.mkdir()) return;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile))) {
            bufferedWriter.write(report.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static String parse(String inputStr, boolean debug) {
        if (!Depository.block) {
            Depository.inputLines.add(inputStr);
            Logger.getLogger().logWrite("In: " + inputStr);
        }
        inputStr = inputStr.trim();

        try {
            if (!bracketsCheck(inputStr)) {
                throw new CalcError("Скобки расставлены неверно");
            }
        } catch (CalcError e) {
            if (!Depository.block) {
                System.out.println("Out: " + e.getMessage());
                Logger.getLogger().logWrite("Out: " + e.getMessage());
                Depository.outputLines.add(e.getMessage());
            }
            return null;
        }
        return brackets(inputStr, debug);
    }

    private static boolean bracketsCheck(String str) {
        try {
            char[] strToChar = str.toCharArray();
            LinkedList<Character> l = new LinkedList<>();
            for (char s : strToChar) {
                switch (s) {
                    case '{':
                        l.push('{');
                        break;
                    case '(':
                        l.push('(');
                        break;
                    case '}':
                        if (l.pop() != '{') return false;
                        break;
                    case ')':
                        if (l.pop() != '(') return false;
                        break;
                }
            }
            return l.isEmpty();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static String brackets(String inputStr, boolean debug) {
        String res = null;
        char[] inputStrToChar = inputStr.toCharArray();
        int leftB = -1;
        int rightB = -1;
        for (int i = 0; i < inputStrToChar.length; i++) {
            if (inputStrToChar[i] == '(') leftB = i;
            else if (inputStrToChar[i] == ')') {
                rightB = i;
                break;
            }
        }
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(inputStr);
        if (leftB != -1 && rightB != -1) {
            Parser parser = debug ? new Parser(resultStr.substring(leftB + 1, rightB), Parser.Debug.ON) : new Parser(resultStr.substring(leftB + 1, rightB));
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            FutureTask<String> task = new FutureTask<>(parser);
            executorService.submit(task);
            try {
                res = task.get();
                if (res == null) {
                    executorService.shutdown();
                    return null;
                }
                return brackets(resultStr.replace(leftB, rightB + 1, res).toString(), debug);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
        Parser parser = debug ? new Parser(resultStr.toString(), Parser.Debug.ON) : new Parser(resultStr.toString());
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<String> task = new FutureTask<>(parser);
        executorService.submit(task);
        try {
            res = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        if (res == null) return null;
        return res;
    }

}
