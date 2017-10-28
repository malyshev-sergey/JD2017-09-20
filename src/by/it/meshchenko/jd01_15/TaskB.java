package by.it.meshchenko.jd01_15;

import by.it.meshchenko.Util.Util;
import by.it.meshchenko.calc.Parser;

import java.io.*;
import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static boolean flag = false;
    private static  int i = 1;

    static void example1() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileNameRead = src + "jd01_15/Runner15.java";
        String fileNameWrite = src + "jd01_15/Runner15.txt";

        try(BufferedReader fr = new BufferedReader(
                new FileReader(Paths.get(fileNameRead).toAbsolutePath().toString()));
            BufferedWriter fw = new BufferedWriter(
                    new FileWriter(Paths.get(fileNameWrite).toAbsolutePath().toString()))
        ) {
            String strRead;
            String strWrite;

            while((strRead = fr.readLine()) != null) {
                strWrite = strWithoutComments(strRead, true);
                if(!strWrite.isEmpty()){
                    System.out.println(strWrite);
                    strWrite = strWrite.concat("\r\n");
                    fw.write(strWrite);
                }
            }
            System.out.println("Запись в файл '" + Paths.get(fileNameWrite).getFileName() + "' закончена");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String strWithoutComments(String str, boolean numbStr){
        StringBuilder res = new StringBuilder("");
        StringBuilder temp = new StringBuilder(str);

        Pattern pC1F = Pattern.compile(Patterns.comm1Full);
        Pattern pC1S = Pattern.compile(Patterns.comm1Start);
        Pattern pC1E = Pattern.compile(Patterns.comm1End);
        Pattern pC2F = Pattern.compile(Patterns.comm2Full);
        if(!flag){
            deletePatternsStr(temp, pC1F, 0);
            deletePatternsStr(temp, pC2F, 0);
        }
        deletePatternsStr(temp, pC1E, 2);
        deletePatternsStr(temp, pC1S, 1);

        String ttS = new String(temp);
        if(numbStr && !ttS.isEmpty() && !ttS.trim().isEmpty()){
            res.append(Util.strDefiniteSize(Integer.toString(i), 3, "0"));
            res.append(" " + temp);
            i++;
        }
        return res.toString();
    }

    private static void deletePatternsStr(StringBuilder temp, Pattern p, int trigger){
        StringBuilder tempDel = new StringBuilder(temp);
        Matcher m = p.matcher(temp);
        String findStr;
        boolean findFlag = false;
        int ind;

        while (m.find()){
            findFlag = true;
            if(trigger == 1) flag = true;
            if(trigger == 2) flag = false;
            findStr= m.group();
            ind = tempDel.indexOf(findStr);
            tempDel.delete(ind, ind + findStr.length());
        }
        temp.delete(0,temp.length()).append(tempDel);

        if(flag && !findFlag ){
            temp.delete(0,temp.length()).append("");
        }
    }
}
