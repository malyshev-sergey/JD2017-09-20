package by.it.mustaphin.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

//Имя класса
public class TaskB {

    //Метод чтения сдержимого файла класса
    void read() {
        String src = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/TaskB.java";
        String out = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/TaskB.txt";
        StringBuilder sb = new StringBuilder();

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
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}
