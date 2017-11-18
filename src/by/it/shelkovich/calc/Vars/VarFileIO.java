package by.it.shelkovich.calc.Vars;

import by.it.shelkovich.calc.Parser;

import java.io.*;
import java.util.Map;

public class VarFileIO {
    File file;
    public VarFileIO(String path){
        file = new File(path);
    }
    public VarFileIO(){
        file = new File(System.getProperty("user.dir") + "/src/by/it/shelkovich/calc/vars.txt");
    }


    public void saveToFile(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (Map.Entry<String, Var> varEntry: VarStorage.vars.entrySet()) {
                bufferedWriter.write(varEntry.getKey()+"="+varEntry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void loadFromFile(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = bufferedReader.readLine()) != null) {
                Parser parser = new Parser();
                parser.exeOp(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
