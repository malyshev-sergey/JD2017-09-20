package by.it.shelkovich.jd1_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    static void run(){
        File f = new File(Util.getLocalPath(), "sourceText");
        StringBuilder sb = null;
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            int ch;
            sb = new StringBuilder((int)f.length());
            while ((ch = br.read()) != -1){
                sb.append((char) ch);
            }
        }catch(IOException e){
            System.out.println("Ошибка ввода/вывода");
            e.printStackTrace();
        }

        Matcher m = Pattern.compile(" ").matcher(sb);
        int wordCount = 0;
        int punctMarkCount = 0;
        while(m.find()) wordCount++;
        m = Pattern.compile("[,;.:]+").matcher(sb);
        while(m.find()) punctMarkCount++;
        System.out.printf("Слов: %d, знаков препинания: %d\n", wordCount, punctMarkCount);
    }
}
