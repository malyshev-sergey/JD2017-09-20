package by.it.dubrova.jd01_14;

import java.io.*;
import java.util.*;

public class TaskC {
    public static void main(String[] args) {

        List<String> files = new ArrayList<>();
        List<String> folders = new ArrayList<>();

        File f = new File("D:/JavaAcademy/");

        for (int i = 0; i < f.listFiles().length; i++){
            if (f.listFiles()[i].isDirectory())
                folders.add(f.listFiles()[i].getName().toString());
            else files.add(f.listFiles()[i].getName().toString());
        }

        System.out.println("files: " + files);
        System.out.println("folders: " + folders);

    }
}
