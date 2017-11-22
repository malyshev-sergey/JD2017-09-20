package by.it.malyshev.jd01_15;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TaskC {

    private static Path p;

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir");
        p = Paths.get(path);
        System.out.print("\n"+p.toString() + " > ");

        String inputLine;

        label:
        while (true) {
            inputLine = getCommandLine();
            List<String> parseInputLine = new ArrayList<>();
            parseInputLine.addAll(Arrays.asList(inputLine.split(" ")));
            parseInputLine.removeIf(s -> s.equals(""));
            if (parseInputLine.size() > 2) {
                System.out.print(p.toString() + " > ");
                continue;
            }

            String command = parseInputLine.get(0).toLowerCase();

            switch (command) {
                case "cd":
                    cd(parseInputLine.get(1));
                    break;
                case "dir":
                    dir();
                    break;
                case "exit":
                    break label;
            }
            System.out.print(p.toString() + " > ");
        }

    } //main

    private static String getCommandLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = null;
        try {
            inputLine = br.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }

    private static void cd(String newPath) {
        Path temp=p;
        try {
            if (newPath.charAt(0) == '\\') {
                temp = Paths.get(p.getRoot().toString() + newPath.substring(1));
            } else if (newPath.length() > 1 && newPath.substring(0, 2).equals("..")) {
                temp = Paths.get(p.getParent().toString() + newPath.substring(2));
            } else if (newPath.contains(":\\")) {
                temp = Paths.get(newPath);
            } else if (newPath.equals(".")) {
                temp=p;
            } else if (newPath.length() > 1 && newPath.substring(0, 2).equals(".\\")) {
                temp = Paths.get(p.toString() + newPath.substring(1));
            } else
                temp = Paths.get(p.toString() + "\\" + newPath);
        } catch(InvalidPathException ignored) {}
        if (Files.exists(temp)) {
            p = temp;
        }
    }

    private static void dir() {

        File f = new File(p.toString());
        File[] files = f.listFiles();
        if (files!=null) {Arrays.sort(files);}
        int counterFiles = 0;
        int counterFolders = 0;
        long length = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("converter.MM.yyyy KK:mm:ss");

        FileSystemView view = FileSystemView.getFileSystemView();
        System.out.print ("\nТом в устройстве "+p.getRoot().toString().substring(0,1).toUpperCase());
        String volumeLabel =view.getSystemDisplayName(new File(p.getRoot().toString()));
        int index = volumeLabel.lastIndexOf(" (");
        if (index > 0) {
            volumeLabel = volumeLabel.substring(0, index);
        }
        if (volumeLabel.equals("Локальный диск")) System.out.println(" не имеет метки");
        else System.out.println(" имеет метку "+volumeLabel);

        if (System.getProperty("os.name").toLowerCase().contains("windows"))
        System.out.println("Серийный номер тома: "+getVolumeSerialId());

        System.out.println("\nСодержимое папки " + p.toAbsolutePath() + "\n");
        try {
            if (files!=null) {
                for (File s : files) {
                    Path dir = Paths.get(s.getPath());
                    String isDir;
                    if (Files.getAttribute(dir, "isDirectory").equals(true)) {
                        isDir = " <dir> ";
                        counterFolders++;
                    } else {
                        isDir = "       ";
                        counterFiles++;
                        length += s.length();
                    }
                    System.out.printf(" %s %s %10d  %s\n",
                            dateFormat.format(Files.getLastModifiedTime(dir).toMillis()), isDir,
                            Files.size(dir),
                            s.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("           %5d %7s %14d байт\r\n",
                counterFiles, gramaticalCase(counterFiles, true), length);
        System.out.printf("           %5d %7s %14d байт свободно\r\n",
                counterFolders,gramaticalCase(counterFolders, false),f.getUsableSpace());

        System.out.println();


    }

    private static String getVolumeSerialId() {

        try {
            Process pr = Runtime.getRuntime().exec("cmd /C dir "+p.getRoot().toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            int count = 0;
            while ((line = in.readLine()) != null) {
                count++;
                if (count < 2)
                    continue;
                if (count > 2)
                    break;
                return line.substring(line.lastIndexOf(' ') + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String gramaticalCase(int q, boolean isFiles) {
        String res;
        int a = q;
        while (a >= 100) a -= 100;
        a /= 10;
        int b = q % 10;
        if ((a == 0 || a > 1) && (b == 2 || b == 3 || b == 4)) {
            if (isFiles) res = "файла ";
            else res = "папки ";
        } else if ((a == 0 || a > 1) && (b == 1)) {
            if (isFiles) res = "файл  ";
            else res = "папка ";
        } else {
            if (isFiles) res = "файлов ";
            else res = "папок  ";
        }
        return res;
    }


} //TaskC



