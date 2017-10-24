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
        System.out.println("getInfo() " + file.getAbsolutePath());
        File files[] = file.listFiles();
        for (File inner : files) {
            if (inner.isDirectory()) {
                mapDirs.put(inner.getAbsolutePath(), inner);
            } else if (inner.isFile()) {
                mapFiles.put(inner.getAbsolutePath(), inner);
            }
        }
        print();
        getInfo(select());
    }

    File select() {
        if (mapDirs.entrySet().size() == alreadyChecked.size()) {
            print();
        }
        File selectedDir = null;
        boolean bottom = true;
        begin:
        for (Map.Entry<String, File> me : mapDirs.entrySet()) {
            if (alreadyChecked.contains(me.getKey())) {
                continue;
            }
            if (bottom) {
                for (File seekDir : me.getValue().listFiles()) {
                    if (seekDir.isDirectory()) {
                        bottom = false;
                        break;
                    }
                }
                if (bottom) {
                    continue begin;
                }
            }
            alreadyChecked.add(me.getKey());
            selectedDir = me.getValue();
            break;
        }
        System.out.println((null == selectedDir) ? "null" : "NOT null");
        return selectedDir;
    }

    void print() {

        for (Map.Entry<String, File> dir : mapDirs.entrySet()) {
            System.out.printf("Директория %s, %s\n", dir.getKey(), dir.getValue().getName());
        }
        System.out.println();
        for (Map.Entry<String, File> file : mapFiles.entrySet()) {
            System.out.printf("Файл %s\n", file.getKey());
        }
//        System.exit(0);
    }
}
