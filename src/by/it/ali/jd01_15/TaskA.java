package by.it.ali.jd01_15;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskA {


    static void SolveTaskA() {
        String src = System.getProperty("user.dir") + "/src/by/it/ali/";
        try{
            String out = src + "jd01_15/out.txt";
            ArrayList<Integer> matr = new ArrayList<>();
//            ArrayList<Integer> matr = new ArrayList<Integer>(){
//                public String toString(){
//                    int n=0;
//                    StringBuilder out = new StringBuilder();
//                    for (Integer s:this) {
//                        out.append(n).append(": ").append(s).append("\n");n++;}
//                    return out.toString();
//                }
//            };
            for (int i = 0; i < 16; i++) {
                Integer key = -15 + (int) (Math.random() * 30);
                matr.add(i, key);
            }
            for (int i = 0; i < 13; i = i + 4) {
                System.out.printf("{%4d%4d%4d%4d}\n", matr.get(i), matr.get(i + 1), matr.get(i + 2), matr.get(i + 3));
            }

            //PrintWriter printer = new PrintWriter(new FileWriter(out, true));
            FileWriter printer = new FileWriter(out,true);
            for (int i = 0; i < matr.size() ; i++) {
                String ss = Integer.toString(matr.get(1));
                printer.write(ss);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
