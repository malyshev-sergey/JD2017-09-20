package by.it.meshchenko.jd02_05;

import by.it.meshchenko.Util.Util;
import java.io.*;
import java.nio.file.Paths;

public class EmulatorNative2ascii {
    static void run(String srcRead, String file) {
        if(srcRead.compareTo("") == 0)
            srcRead = System.getProperty("user.dir") + "/src/by/it/meshchenko/jd02_05/txt/";

        String fileNameRead = srcRead + file;
        String srcWrite = System.getProperty("user.dir") + "/src/by/it/meshchenko/jd02_05/res2/";
        String fileNameWrite = srcWrite + file.split("\\.")[0] + ".properties";

        try (BufferedReader fr = new BufferedReader(
                new FileReader(Paths.get(fileNameRead).toAbsolutePath().toString()));
             BufferedWriter fw = new BufferedWriter(
                     new FileWriter(Paths.get(fileNameWrite).toAbsolutePath().toString()))
        ) {
            String strRead;
            StringBuilder strWrite = new StringBuilder();

            while ((strRead = fr.readLine()) != null) {

                String[] arr = strRead.split("=");
                strWrite.append(arr[0] + "=");
                String strValue = strRead.substring(strRead.indexOf(strWrite.toString()) + strWrite.length(), strRead.length());

                for(int i = 0; i < strValue.length(); i++){
                    char cd = strValue.charAt(i);
                    int code = (int)cd;
                    if(code > 127) {
                        strWrite.append("\\u");
                        strWrite.append(Util.strDefiniteSize(Integer.toHexString(code),4, "0"));
                    }
                    else
                        strWrite.append(Character.toString(cd));
                }
                strWrite.append("\r\n");
                fw.write(strWrite.toString());
                strWrite.delete(0, strWrite.length());
            }
            System.out.println("Запись в файл '" + Paths.get(fileNameWrite).getFileName() + "' закончена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
