package by.it.mustaphin.jd01_14;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskC {

    Map<String, File> mapFiles = new HashMap<>();
    Set<String> checked = new HashSet<>();
    int size = mapFiles.size(), current;
    Map<String, File> mapDirs = new HashMap<>();

    void getInfo(File file) {
        File files[] = file.listFiles();
        for (File inner : files) {
            if (inner.isDirectory()) {
                mapDirs.put(inner.getAbsolutePath(), inner);
            } else if (inner.isFile()) {
                mapFiles.put(inner.getAbsolutePath(), inner);
            }
        }
    }

    File select() {
        Set<Map.Entry<String, File>> dirs = mapDirs.entrySet();
        for (Map.Entry<String, File> me : dirs) {

        }
        return null;
    }
}
