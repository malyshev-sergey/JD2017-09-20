package by.it.malyshev.jd01_14;

import java.io.File;

public class TaskC {

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") + "/src/by/it/malyshev";

        System.out.println("\nСписок файлов");
        getListFilesDirs(dir, true);
        System.out.println("\nСписок каталогов");
        getListFilesDirs(dir, false);

    }

    private static void getListFilesDirs(String dir, boolean needFile) {
        File[] files =(new File(dir)).listFiles();
        if (!(files==null)) {
            for (File s : files) {
                if (s.isFile()) {
                    if (needFile) System.out.println(s.getName());
                } else if (s.isDirectory()) {
                    if (!needFile) System.out.println(s.getName());
                    getListFilesDirs(s.getPath(), needFile);
                }
            }
        } else {
            System.out.println("Нет такого каталога");
        }
    }


}



