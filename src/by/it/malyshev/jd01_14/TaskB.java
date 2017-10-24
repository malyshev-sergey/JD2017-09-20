package by.it.malyshev.jd01_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir") + "/src/by/it/malyshev/jd01_14";
        String filename = "text.txt";
        File f = new File(dir, filename);

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            int c;
            StringBuilder sb = new StringBuilder();
            while ((c = br.read()) != -1) sb.append((char) c);

            Matcher m = Pattern.compile("[A-za-zА-яЯа-яЁё]+[0-9]?").matcher(sb);
            int words = 0;
            int punctuationMarks = 0;
            while (m.find()) words++;
            m = Pattern.compile("[.,;:?!«»—()]").matcher(sb);
            while (m.find()) punctuationMarks++;
            System.out.println("\nВ файле " + filename + " " + punctuationMarks + " знаков препинания и " + words + " слов");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
