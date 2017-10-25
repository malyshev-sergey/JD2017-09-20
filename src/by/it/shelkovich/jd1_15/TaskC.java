package by.it.shelkovich.jd1_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    static void run() {
        System.out.println("Коммандная строка приветствует вас!");
        Scanner scanner = new Scanner(System.in);
        File currentDir = new File(System.getProperty("user.dir"));

        while (true) {
            System.out.print(currentDir.getPath() + ">");
            String line = scanner.nextLine();

            Matcher m = Pattern.compile("cd (.+)").matcher(line);

            if ("dir".equals(line)) {
                dir(currentDir);
            } else if (m.matches()) {
                currentDir = cd(currentDir, m.group(1));
            } else if ("exit".equals(line)){
                break;
            } else {
                System.out.printf("\"%s\" не является внутренней или внешней\n" +
                        "командой, исполняемой программой или пакетным файлом.\n", line);
            }
        }
    }

    static File cd(File currentDir, String pathStr){
        Path path = Paths.get(currentDir.getPath());
        Path newPath = path.resolve(pathStr).normalize();

        if (Files.isDirectory(newPath)) {
            return new File(newPath.toString());
        } else {
            System.out.println("Системе не удается найти указанный путь.");
            return currentDir;
        }
    }

    static void dir(File file) {
        String[] files = file.list();
        System.out.printf(" Содержимое папки %s\n\n", file.getPath());
        for (String fileName : files) {
            Path path = Paths.get(file.getPath(), fileName);
            try {
                long time = Files.getLastModifiedTime(path).toMillis();
                System.out.printf("%td.%<tm.%<tY %<tH:%<tM ", time);
                if (Files.isDirectory(path)) System.out.printf("<DIR>          %s", fileName);
                else System.out.printf("%14d %s", Files.size(path), fileName);
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
