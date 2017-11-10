package by.it.ali.jd01_14;

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
//       while (sc.hasNext()){
//           str = sc.findInLine("[,.;!?]");
//           if(str!=null){
//               count++;
//               System.out.print(str);
//           }
//           }
 //------------------- Попытка использовать Delimiter
        sc.useDelimiter("([a-zA-Z“”]|\\s|\\n)+");
            while (sc.hasNext()){
                String str=sc.next();
                System.out.print(str);
                count++;
            }
        sc.close();
        sc = new Scanner(new FileInputStream(numbers));
        sc.useDelimiter("([,.;!?]|\\s|\\n)+");
            while (sc.hasNext()) {
                String word = sc.next();
                System.out.print(word + " ");
                worded++;
            }
        sc.close();
        System.out.println("");
      System.out.println("Знаков препинания в тексте: "+count);
      System.out.println("Слов в тексте: "+worded);
    }
}