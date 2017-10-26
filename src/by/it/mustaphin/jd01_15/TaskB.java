package by.it.mustaphin.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Имя класса
public class TaskB {

    StringBuilder sb = new StringBuilder();

    //Метод чтения сдержимого файла класса
    void read() {
        String src = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/TaskB.java";
        String out = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/TaskB.txt";

        /**try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src))))) {
         String line;
         while ((line = br.readLine()) != null) {
         sb.append(line);
         }
         } catch (FileNotFoundException e) {
         e.printStackTrace();
         } catch (IOException e) {
         e.printStackTrace();
         }*/

        //Новый более продвинутый способ читать файлы
        try {
            for (String line : Files.readAllLines(Paths.get(src))) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        removeComments();
    }

    void removeComments() {
        Pattern patMultiComent = Pattern.compile("/[*]+[a-zA-Z0-9()=!. \\n{};]+[*]/");
        Pattern patLineComent = Pattern.compile("// .+[\\n]?");
        Matcher mat = patMultiComent.matcher(sb);
        String newLine[] = sb.toString().split(String.valueOf(patMultiComent));
        sb.setLength(0);
        for (String line : newLine) {
            sb.append(line);
        }

    }
}