package by.it.govor.jd01.jd01_15;

import java.io.*;


class TaskB {
    static void taskB() {
       StringBuilder string = new StringBuilder();
       File file = new File(System.getProperty("user.dir")+"/srt/by/it/govor/jd01_15/TaskB.class");
       File txtFile = new File(System.getProperty("user.dir")+"/srt/by/it/govor/jd01_15/TaskB.txt");
       try(
               FileInputStream inputFile = new FileInputStream(file);
           FileOutputStream outFile  = new FileOutputStream(txtFile);
       BufferedReader read = new BufferedReader(new InputStreamReader(inputFile));
       BufferedWriter write = new BufferedWriter(new OutputStreamWriter(outFile));
       ){


           while(read.readLine()!=null){
               string.append(read.readLine()+"\n");
           }
           System.out.println(string);

           String[] s = string.toString().split("/n");
           for (int i = 0; i <s.length ; i++) {
               write.write(s[i]);
               write.newLine();
           }
       }catch (Exception e){
           System.out.println("Пошел нафиг сраный урод(Это для меня))");
       }

   }
}
