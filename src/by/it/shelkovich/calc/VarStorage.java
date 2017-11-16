package by.it.shelkovich.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VarStorage {
    public static HashMap<String, Var> vars = new HashMap<>();

    public static void printVar(){
        System.out.println("Сохранённые переменные: ");
        for(Map.Entry<String, Var> var: vars.entrySet()){
            System.out.printf("%s - %s\n", var.getKey(), var.getValue().toString());
        }
    }

    public static void sortVar(){
        System.out.println("Отсортированные сохранённые переменные: ");
        TreeMap <String, Var> sortedVars = new TreeMap<>(vars);
        for(Map.Entry<String, Var> var: sortedVars.entrySet()){
            System.out.printf("%s - %s\n", var.getKey(), var.getValue().toString());
        }
    }

    public static void put(String name, Var var){
        vars.put(name,var);
    }

    public static Var get(String name){
        return vars.get(name);
    }
}
