package by.it.govor.jd01.jd01_15;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskC {
    static void taskC() {


       File file = new File(System.getProperty("user.dir") + "/src/by/it/govor/jd01/jd01_15/TaskB.java");
       boolean flag = true;

       StringBuilder s = new StringBuilder();
       Pattern p = Pattern.compile("cd/");
       String string;
       String way=System.getProperty("user.dir") + "/src/by/it/govor/jd01_15/TaskB.java";
       try( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
           while (flag) {
               string= reader.readLine();
               Matcher m =p.matcher(string);
               if(m.find()){
                   way =string.substring('/');
                file = new File(way);
                   System.out.println("Путь изменен");

               }
               if (string.equals("dir")){
                   System.out.println(way);
               }
               if (string.equals("exit")){
                   flag=false;
               }



           }
       }catch (IOException e){
           System.out.println("Все плохо");
       }

   }
}
