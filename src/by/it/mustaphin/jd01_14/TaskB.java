package by.it.mustaphin.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    String text;

    void read() {
        String src = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_14/text";
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(new File(src))) {
            int letter;
            while ((letter = fr.read()) != -1) {
                sb.append((char) letter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = sb.toString();
    }

    void count() {
        read();
        Pattern patWord = Pattern.compile("[a-zA-Z]+");
        Matcher matWords = patWord.matcher(text);
        int counter = 0;
        while (matWords.find()) {
            ++counter;
        }
        System.out.println("Количество слов " + counter);
        Pattern patPunc = Pattern.compile("[-.,;:]+");
        Matcher matPunc = patPunc.matcher(text);
        counter = 0;
        while (matPunc.find()) {
            ++counter;
        }
        System.out.println("Количество знаков припенания " + counter);

    }

}
