package by.it.malyshev.jd01_14;

import java.io.File;

public class TaskC {

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") + "/src/by/it/malyshev";

        System.out.println("\nСписок файлов");
        getListFiles(dir, true);
        System.out.println("\nСписок каталогов");
        getListFiles(dir, false);

    }

    private static void getListFiles(String dir, boolean isFile) {
        File[] files =(new File(dir)).listFiles();
        if (!(files==null)) {
            for (File s : files) {
                if (s.isFile()) {
                    if (isFile) System.out.println(s.getName());
                } else if (s.isDirectory()) {
                    if (!isFile) System.out.println(s.getName());
                    getListFiles(s.getPath(), isFile);
                }
            }
        } else {
            System.out.println("Нет такого каталога");
        }
    }


}



