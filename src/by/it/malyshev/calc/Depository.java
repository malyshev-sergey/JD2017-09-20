package by.it.malyshev.calc;

import java.io.*;
import java.util.*;

class Depository {

    static Map<String, Var> variablesCollection = new HashMap<>();
    private static File varsFile= new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/vars.txt");
    private static File logFile = new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/log.txt");
    private static LinkedList<String> logList = new LinkedList<>();

    static void printVar() {
        System.out.println("\nКоллекция переменных");
        for (Map.Entry<String, Var> stringVarEntry : variablesCollection.entrySet())
            System.out.println(stringVarEntry);
    }

    static void sortVar() {
        System.out.println("\nОтсортированная коллекция переменных");
        TreeMap<String, Var> sortedVariables = new TreeMap<>(variablesCollection);
        for (Map.Entry<String, Var> stringVarEntry : sortedVariables.entrySet())
            System.out.println(stringVarEntry);
    }




    static void store(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(varsFile))){
            for (Map.Entry<String, Var> varEntry: Depository.variablesCollection.entrySet()) {
                bufferedWriter.write(varEntry.getKey()+"="+varEntry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void restore(){
        String inputLine;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(varsFile))){
            while((inputLine = bufferedReader.readLine()) != null) {
                Parser.fromString(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static void logWrite(String str) {
        logList.clear();
        if (logFile.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while((line = bufferedReader.readLine()) != null){
                    logList.addLast(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logList.addLast(str);
        while(logList.size()>50) logList.pop();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile))) {
//            int counter=0;
            for (String v : logList) {
                bufferedWriter.write(v);
              bufferedWriter.newLine();

//                if (counter>1) counter=0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
