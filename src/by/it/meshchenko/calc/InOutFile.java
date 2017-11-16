package by.it.meshchenko.calc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class InOutFile {

    static LinkedHashMap<String, String> read() throws IOException {
        LinkedHashMap<String, String> res = null;
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src + "calc/vars.txt";
        try(BufferedReader fr = new BufferedReader(
                new FileReader(Paths.get(fileName).toAbsolutePath().toString())))
        {
            String strRead;
            res = new LinkedHashMap<>();
            //    String strWrite;
            while((strRead = fr.readLine()) != null) {
                Expression ex = Parser.parseAssign(strRead);
                if(ex != null) res.put(ex.getName(), ex.getStrValue());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return res;
    }

    static void write(LinkedHashMap<String, String> map) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src + "calc/vars.txt";

        try (BufferedWriter fw = new BufferedWriter(
                new FileWriter(Paths.get(fileName).toAbsolutePath().toString()))) {
            StringBuilder str = new StringBuilder();
            for (Iterator<Map.Entry<String, String>> itm = map.entrySet().iterator(); itm.hasNext(); ) {
                Map.Entry<String, String> p = itm.next();
                str.append(p.getKey() + "=" + p.getValue());
                if (itm.hasNext()) str.append("\n");
            }
            if (!str.toString().isEmpty()) {
                fw.write(str.toString());
            }
            System.out.println("Запись в файл '" + Paths.get(fileName).getFileName() + "' закончена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
