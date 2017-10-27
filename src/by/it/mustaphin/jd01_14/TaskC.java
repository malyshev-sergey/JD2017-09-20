package by.it.mustaphin.jd01_14;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskC {

    Map<String, File> mapFiles = new HashMap<>();
    Set<String> alreadyChecked = new HashSet<>();
    Map<String, File> mapDirs = new HashMap<>();

    void getInfo(File file) {
        File files[] = file.listFiles();
        for (File inner : files) {
            if (inner.isDirectory()) {
                mapDirs.put(inner.getAbsolutePath(), inner);
            }
        }
//        print();
        File dir = selectDir();
        if (null == selectDir()) {
            seekFiles();
        } else {
            getInfo(selectDir());
        }
    }

    boolean isBottom(File file) {
        for (File seekDir : file.listFiles()) {
            if (seekDir.isDirectory()) {
                return false;
            }
        }
        return true;
    }

    void seekFiles() {
        for (Map.Entry<String, File> me : mapDirs.entrySet()) {
            File dir[] = me.getValue().listFiles();
            for (File file : dir) {
                if (file.isFile()) {
                    mapFiles.put(file.getAbsolutePath(), file);
                }
            }
        }
        print();
        System.exit(0);
    }

    File selectDir() {
        File selectedDir = null;
        for (Map.Entry<String, File> me : mapDirs.entrySet()) {
            if (alreadyChecked.contains(me.getKey())) {
                continue;
            }
            if (!isBottom(me.getValue())) {
                alreadyChecked.add(me.getKey());
                selectedDir = me.getValue();
            }
        }
        return selectedDir;
    }

    void print() {
        for (Map.Entry<String, File> dir : mapDirs.entrySet()) {
            System.out.printf("Директория %s\n", dir.getKey());
        }
        System.out.println();
        for (Map.Entry<String, File> file : mapFiles.entrySet()) {
            System.out.printf("Файл %s\n", file.getKey());
        }
    }
}
