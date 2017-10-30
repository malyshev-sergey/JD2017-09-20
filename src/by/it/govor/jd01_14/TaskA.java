package by.it.govor.jd01_14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


class TaskA {
   File file = new File(System.getProperty("user.dir")+"/srt/by/it/govor/jd01_14/text.txt");
    public void taskA() {


       try (FileOutputStream write = new FileOutputStream(file)) {
           for (int i = 0; i < 20; i++) {
               write.write((int) Math.random() + 20 * 8);
           }
       } catch (IOException e) {
           System.out.println("Ошибка записи файла:" + e);

       }
   }

   public   void read() {
       double s=0;
       int z=0;
       try(FileInputStream read = new FileInputStream(file)){
        while(read.available()>0){
            s=(int)read.read();
            z++;
        }
       }catch (IOException e){
           System.out.println("Ошибка чтения файла:"+e);
       }
       System.out.println(s/z);
   }
}
