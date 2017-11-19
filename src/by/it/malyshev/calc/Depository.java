package by.it.malyshev.calc;

import java.io.*;
import java.util.*;

public class Depository {

    static Map<String, Var> variablesCollection = new HashMap<>();
    private static File varsFile = new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/out/vars.txt");
    public static long programStartTime;
    public static long programFinishTime;
    public static List<String> inputLines = new ArrayList<>();
    public static List<String> outputLines = new ArrayList<>();
    static boolean block;

    static void printVar() {
        System.out.println("\nКоллекция переменных");
        for (Map.Entry<String, Var> stringVarEntry : variablesCollection.entrySet())
            System.out.println(stringVarEntry);
    }

    public static String[] varColtoString() {
        TreeMap<String, Var> sortedVariables = new TreeMap<>(variablesCollection);
        String[] res = new String[sortedVariables.size()];
        int counter = 0;
        for (Map.Entry<String, Var> stringVarEntry : sortedVariables.entrySet())
            res[counter++] = stringVarEntry.toString();
        return res;
    }


    static void sortVar() {
        System.out.println("\nОтсортированная коллекция переменных");
        TreeMap<String, Var> sortedVariables = new TreeMap<>(variablesCollection);
        for (Map.Entry<String, Var> stringVarEntry : sortedVariables.entrySet())
            System.out.println(stringVarEntry);
    }


    static void store() {
        File varDir = new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/out");
        if (!varDir.exists())
            if (!varDir.mkdir()) return;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(varsFile))) {
            for (Map.Entry<String, Var> varEntry : Depository.variablesCollection.entrySet()) {
                bufferedWriter.write(varEntry.getKey() + "=" + varEntry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void restore() {
        String inputLine;
        block = true;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(varsFile))) {
            while ((inputLine = bufferedReader.readLine()) != null) {
                ConsoleRunner.parse(inputLine, false);
            }

        } catch (Exception e) {
            System.out.println("Пока нет файла с сохраненными переменными");
            block = false;
        }
        block = false;
    }


}
