package by.it.malyshev.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class TaskC {

    public static void main(String[] args) throws IOException {

        String src=System.getProperty("user.dir");

        // Cоздание объекта Path через вызов статического метода get() класса Paths
        Path d = Paths.get(src);


        //Вывод информации о файле
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + d.getFileName());
        System.out.println("\t root of the path: " + d.getRoot());
        System.out.println("\t parent of the target: "
                + d.getParent());

        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : d) {
            System.out.println("\t path element: " + element);
        }

        File f=new File(src);
        File[] files=f.listFiles();
        Arrays.sort(files);

//        File[] files =(dir.new File(dir)).listFiles();
//        if (files!=null) {
//            for (File s : files) {
//                if (s.isFile()) {
//                    if (needFile) System.out.println(s.getName());
//                } else if (s.isDirectory()) {
//                    if (!needFile) System.out.println(s.getName());
//                    getListFilesDirs(s.getPath(), needFile);
//                }
//            }
//        } else {
//            System.out.println("Нет такого каталога");
//        }




//        src = System.getProperty("user.dir") + "/src/by/it/akhmelev/";
//        fileInTxt = src + "jd01_15/in.txt";
//        String fileBak = src + "jd01_15/in.bak";
//        String fileMove = src + "jd01_15/in.move";
//        // Cоздание объекта Path через вызов статического метода get() класса Paths
//        Path path = Paths.get(fileInTxt);
//        Path pathForCopy= Paths.get(fileBak);
//        Path pathForMove= Paths.get(fileMove);
//        //проверка свойств файла (каталога)
//        System.out.printf("Readable: %b, Writable: %b, Executable: %b\n",
//                Files.isReadable(path), Files.isWritable(path),
//                Files.isExecutable(path));
//        //проверка аттрибутов файла (каталога)
//        System.out.printf("Creation time: %s\nLast modified time: %s\nSize: %s\nDir: %s\n",
//                Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS),
//                Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS),
//                Files.getAttribute(path, "size"),
//                Files.getAttribute(path, "isDirectory")
//        );
//        //копирование файла(ов) (StandardCopyOption.REPLACE_EXISTING - перезапись)
//        Files.copy(path,pathForCopy, StandardCopyOption.REPLACE_EXISTING);
//        //перенос файла(ов) (StandardCopyOption.REPLACE_EXISTING - перезапись)
//        Files.move(pathForCopy, pathForMove, StandardCopyOption.REPLACE_EXISTING);
//        //удаление файла(ов)
//        Files.delete(pathForMove);
        int counterFiles=0;
        int counterFolders=0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy KK:mm:ss");
        System.out.println("Содержимое папки "+d.toAbsolutePath()+"\n");
        for (File s : files) {
            Path dir=Paths.get(s.getPath());
            String isDir;
            if (Files.getAttribute(dir, "isDirectory").equals(true)) {
                isDir=" <dir> ";
                counterFiles++;
            }
            else {
                isDir="       ";
                counterFolders++;
            }
            System.out.printf(" %s %s %10d  %s\n",
                    dateFormat.format(Files.getLastModifiedTime(dir).toMillis()), isDir,
                    Files.size(dir),/*getAttribute(dir, "size"),*/
                    s.getName());
        }
        System.out.println("                  "+counterFiles+" файлов");
        System.out.println("                  "+counterFolders+" папок");
//
//
//        System.out.println();
//        FileSystemView view = FileSystemView.getFileSystemView();
//        Collection<String> logicalDrives = .getLogicalDriveStrings();
//
//        Kernel32Util
//
    }





}



