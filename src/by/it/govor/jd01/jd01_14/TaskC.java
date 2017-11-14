package by.it.govor.jd01.jd01_14;


import java.io.File;

class TaskC {
    static void taskC() {
       File file = new File(System.getProperty("user.dir") + "/srt/by/it/govor/jd01_14/text2.txt");

       System.out.println("Путь к файлу: " + file.getPath());
       System.out.println("Имя файла: " + file.getName());


   }
}


