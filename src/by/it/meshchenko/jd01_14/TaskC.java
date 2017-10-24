package by.it.meshchenko.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskC {
    public static void example1() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src;
        File f = new File(fileName);

        //Читаем из файла
        ArrayList<File> dirs = new ArrayList<>();
        ArrayList<File> files = new ArrayList<>();
        try {
            if(f.isDirectory()){
                findFile(dirs, files, f.listFiles());
            }
            System.out.println("В директории '" + f.toString() + "':");
            printArrayList(dirs, "dir");
            printArrayList(files, "files");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void findFile(ArrayList<File> dirs, ArrayList<File> files, File[] f){
        for(int i = 0; i < f.length; i++){
            if(f[i].isDirectory()){
                dirs.add(f[i]);
                findFile(dirs, files, f[i].listFiles());
            }
            else {
                files.add(f[i]);
            }
        }
    }

    private static void printArrayList(ArrayList<File> list, String file){
        if(list.size() > 0){
            System.out.printf("Кол-во %s: %d %n", (file.compareTo("dir") == 0 ? "директорий" : "файлов"),
                    list.size());
            int i = 1;
            for(File f : list){
                System.out.println(i +"  "+ f.getName().toString());
                i++;
            }


        }
    }

}
