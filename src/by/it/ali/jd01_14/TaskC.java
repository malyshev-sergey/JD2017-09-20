package by.it.ali.jd01_14;

import java.io.File;
import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir");
        File c = new File(src);
        File[] as = c.listFiles(File::isFile);
        System.out.println("Файлы:"+Arrays.toString(as));
        File[] a = c.listFiles(File::isDirectory);
        System.out.println("Каталоги:"+Arrays.toString(a));
    }
}
