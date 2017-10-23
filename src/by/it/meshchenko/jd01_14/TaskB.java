package by.it.meshchenko.jd01_14;

import by.it.meshchenko.Util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskB {
    public static void example1() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src + "jd01_14/text.txt";
        File f = new File(fileName);

        //Читаем из файла
        int b = 0;
        Character[] punctMark = new Character[]{'.',';',',',':','!','?', '"'};
        Character[] abroadWord = new Character[]{'\r', '\n', ' ', '.', ';', ',', ':', '!', '?', '"'};
        StringBuilder word = new StringBuilder("");
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> mark = new ArrayList<>();

        try(BufferedReader fr = new BufferedReader(new FileReader(fileName))){
            while((b = fr.read()) != -1){
                Character c = (char)b;
                if(!Util.findInArray(abroadWord, c)) {
                    word.append(c);
                }
                else {
                    if(Util.findInArray(punctMark, c)){
                        mark.add(c.toString());
                    }
                    if(word.length() > 0){
                        words.add(new String(word));
                        word.delete(0, word.length());
                    }
                }

            }
            System.out.println("Words count = " + words.size());
            System.out.println("Punctuation mark = " + mark.size());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
