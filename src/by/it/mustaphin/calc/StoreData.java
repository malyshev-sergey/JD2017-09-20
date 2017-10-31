package by.it.mustaphin.calc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class StoreData {

    Properties property = new Properties();

    public StoreData() {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/by/it/mustaphin/calc/vars.txt")) {
            property.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private HashMap<String, Var> data = new HashMap<>();

    void getData() {
        Set<String> vars = property.stringPropertyNames();
        for (String parameter : vars) {
            data.put(parameter, Var.getVar(property.getProperty(parameter)));
        }
    }

    static void store(String name, Var var) {
        data.put(name, var);
    }

    static void sortvar() {
        SortedMap<String, Var> dataSorted = new TreeMap(data);
        Set<Map.Entry<String, Var>> dataSet = dataSorted.entrySet();
        Iterator<Map.Entry<String, Var>> itData = dataSet.iterator();
        while (itData.hasNext()) {
            Map.Entry<String, Var> me = itData.next();
            System.out.printf("%-11s = %s\n", me.getKey(), (null == me.getValue()) ? "Выполнить операцию невозможно либо операция не реализована" : me.getValue());
        }
    }

    static public void printvar() {
        for (Map.Entry<String, Var> couple : data.entrySet()) {
            System.out.printf("%-11s\n", couple.getKey());
        }
    }
}
