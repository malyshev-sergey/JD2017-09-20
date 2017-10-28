package by.it.meshchenko.jd01_15;

import by.it.meshchenko.Util.*;

import java.io.*;
import java.nio.file.attribute.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.Set;

public class TaskA {
    static void example1() throws IOException{
        int[][] res = createTwoMass(4, 4, -15, 15);
        //printTwoMass(res);
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src + "jd01_15/matrix.txt";

        // Если файла нет, создаём файл - без этого блока тоже работает, если файла нет :)
        //if(!Files.exists(path, LinkOption.NOFOLLOW_LINKS)){
            //path = Files.createFile(path);
        //}
        try(BufferedWriter fr = new BufferedWriter(
                new FileWriter(Paths.get(fileName).toAbsolutePath().toString()))) {

            String str = twoMassToString(res, true);
            fr.write(str);
            System.out.println("Запись в файл '" + Paths.get(fileName).getFileName() + "' закончена \n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // Создание матрицы
    private static int[][] createTwoMass(int m, int n, int start, int end){
        int[][] res = null;
        if(m > 0 && n > 0) {
            res = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    res[i][j] = Util.randomInt(start, end);
                }
            }
        }
        return res;
    }

    // Вывод матрицы на экран
    private static String twoMassToString(int[][] res, boolean printConsole){
        StringBuilder strLen = new StringBuilder();
        if(res != null) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    strLen.append(Util.strDefiniteSize(Integer.toString(res[i][j]), 3, " "));
                    if (j < res[0].length) strLen.append(" ");
                }
                if (i < res[0].length - 1) strLen.append("\r\n");
            }
        }
        else{
            System.out.println("Error: Массив равен NULL");
            return "";
        }
        if(printConsole) System.out.println(strLen);
        return strLen.toString();
    }
}
