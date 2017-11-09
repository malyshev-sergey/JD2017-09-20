package by.it.dubrova.jd01_15;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cmd {
    private static String path = "C:\\";  //по дефолту диск Ц

    public static String getPath() {
        return Cmd.path;
    }

    public static void setPath(String path) {
        Cmd.path = path;
    }

    // parse string
    public static void line(String line) {
        String tmp = null;
        tmp = line.split(" ")[0].toUpperCase(); // тут у нас будет комманда цмд

        switch (tmp) {
            case "CD":
                cd(line);
                break;
            case "DIR":
                dir();
                break;
        }
    }

    public static void cd(String line) {
        Path p;
        line = line.substring(3).trim();
        line = getPath() + line;
        //проверяем существует ли каталог и если да - то переходим в него
        p = Paths.get(line);

        if (Files.exists(p)) {
            setPath(line);
            System.out.print(getPath() + ">");
        } else System.out.println("Системе не удается найти указанный путь.\r\n" + getPath() + ">");


    }

    public static void dir() {
        File f = new File(getPath());
        List<String> files = new ArrayList<>();
        List<String> folders = new ArrayList<>();

        for (int i = 0; i < f.listFiles().length; i++) {
            if (f.listFiles()[i].isDirectory())
                folders.add(f.listFiles()[i].getName().toString());
            else files.add(f.listFiles()[i].getName().toString());
        }
        for (int i = 0; i < folders.size(); i++)
            System.out.println("<dir> " + folders.get(i));

        for (int i = 0; i < files.size(); i++)
            System.out.println("<file> " + files.get(i));

        start();
    }

    public static void start(){
        System.out.print(getPath()+">");
    }
}