package by.it.meshchenko.jd01_15;

import by.it.meshchenko.Util.*;
import javafx.scene.input.DataFormat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TaskC {
    static void example1() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko";
        boolean exit = true;

        // Меню командной строки
        while (exit){
            System.out.println("Доступны команды: 'cd', 'cd..', 'dir' или 'end' для выхода: \n");
            System.out.print(src + ">");

            String str = Util.getOneLine();

            if(str.toLowerCase().compareTo("end") == 0) return;
            else {
                try{
                    String com = str.trim();
                    if(com.substring(0,2).compareToIgnoreCase("cd") == 0 ) {
                        src = changeDir(src, str);
                    }
                    else if(com.compareToIgnoreCase("dir") == 0) {
                        showDir(src);
                    }
                    else System.out.println("Неверная команда...");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    //Перемещение по директориям
    private static String changeDir(String src, String str){
        String temp = str.trim().substring(2).trim();
        if(temp.compareTo("..") == 0){
            String res = src.substring(0, src.lastIndexOf("/"));
            System.out.println(res);
            return res;
        }
        else {
            String newDir;
            if(temp.isEmpty()) newDir = src;
             else newDir = src + "/" + temp;
            File f = new File(newDir);
            if(f.isDirectory()){
                return newDir;
            }
            else {
                System.out.println("Неверно задано имя папки.");
            }
        }
        return src;
    }

    // Печатаем директории
    private static void showDir(String currentDir) throws IOException {
        //String dirName = currentDir;
        File f = new File(currentDir);

        // list директорий и файлов
        ArrayList<File> list = new ArrayList<>();
        try {
            if(f.isDirectory()){
                for(File it : f.listFiles())
                list.add(it);
            }
            printArrayList(list);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void printArrayList(ArrayList<File> list){
        if(list.size() > 0){
            for(File f : list){
                System.out.println(f.lastModified() + "  " + f.getName().toString());
            }
        }
    }
}
