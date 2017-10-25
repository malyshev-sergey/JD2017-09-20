package by.it.shelkovich.jd1_14;

import java.io.File;

public class TaskC {
    static void run(){
        File f = new File(System.getProperty("user.dir") + "/src/by/it/shelkovich/");
        System.out.println("Список файлов:");
        printChildFiles(f);
        System.out.println("\nСписок каталогов:");
        printChildDirs(f);
    }

    static void printChildFiles(File f){
        String[] files = f.list();
        for (String fileName: files){
            File file = new File(f.getPath() + "/" + fileName);
            if(file.isDirectory()) printChildFiles(file);
            else System.out.println(fileName);
        }
    }

    static void printChildDirs(File f){
        String[] files = f.list();
        for (String fileName: files){
            File file = new File(f.getPath() + "/" + fileName);
            if(file.isDirectory()){
                System.out.println(fileName);
                printChildDirs(file);
            }
        }
    }
}
