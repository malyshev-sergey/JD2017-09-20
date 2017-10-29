package by.it.halai.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitaly Halai
 */
public class TaskC {
    public static void taskC() {
        List<String> filesName = new ArrayList<>();
        List<String> dirsName = new ArrayList<>();
        String src = System.getProperty("user.dir") + "/src/by/it/halai/";
        File f = new File(src);
        String[] files = f.list();
        for (int i = 0; i < f.listFiles().length; i++) {

            File file = new File(src + "/" + files[i]);
            if (file.isDirectory()) {
                dirsName.add(files[i]);
            } else if (file.isFile()) {
                filesName.add(files[i]);
            }
        }
        System.out.println("Список файлов :");
        for (int j = 0; j < filesName.size(); j++) {
            System.out.println(filesName.get(j));
        }
        System.out.println("Список директорий :");
        for (int j = 0; j < dirsName.size(); j++) {
            System.out.println(dirsName.get(j));
        }
    }
}
