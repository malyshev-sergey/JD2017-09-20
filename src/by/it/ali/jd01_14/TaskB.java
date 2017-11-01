package by.it.ali.jd01_14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws FileNotFoundException {
        String src = System.getProperty("user.dir") + "/src/by/it/ali/";
        String numbers = src + "jd01_14/text.txt";
        Scanner sc = new Scanner(new FileInputStream(numbers));
        int count=0;
        int worded=0;
        String str;
        String words;
       while (sc.hasNext()){
           str = sc.findInLine("[,.;!?]");
           if(str!=null){
               count++;
               System.out.print(str);
           }
           }
// ------------------- Попытка использовать Delimiter
// sc.useDelimiter("[,.;!?\\s]");
//        System.out.println(sc.nextLine());
// ------------------- Паттерн по словам
//       while (sc.hasNext()){
//           worded++;}
//        while (sc.hasNext()) {
//            words = sc.findInLine("[a-zA-Z]+");
//            if (words != null) {
//                worded++;
//                System.out.println(words);
//            }
//        }
        sc.close();
      System.out.println("Знаков препинания в тексте: "+count);
      System.out.println("Слов в тексте: "+worded);
    }
}