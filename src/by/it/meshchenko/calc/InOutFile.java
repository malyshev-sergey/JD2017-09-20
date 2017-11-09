package by.it.meshchenko.calc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class InOutFile {

    static LinkedHashMap<String, String> read() throws IOException {
        LinkedHashMap<String, String> res = null;
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src + "calc/vars.txt";
        try(BufferedReader fr = new BufferedReader(
                new FileReader(Paths.get(fileName).toAbsolutePath().toString())))
        {
            String strRead;
            res = new LinkedHashMap<>();
            //    String strWrite;
            while((strRead = fr.readLine()) != null) {
                Expression ex = Parser.parseAssign(strRead);
                if(ex != null) res.put(ex.getName(), ex.getStrValue());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return res;
    }

    static void write(LinkedHashMap<String, String> map) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src + "calc/vars.txt";

        try (BufferedWriter fw = new BufferedWriter(
                new FileWriter(Paths.get(fileName).toAbsolutePath().toString()))) {
            StringBuilder str = new StringBuilder();
            for (Iterator<Map.Entry<String, String>> itm = map.entrySet().iterator(); itm.hasNext(); ) {
                Map.Entry<String, String> p = itm.next();
                str.append(p.getKey() + "=" + p.getValue());
                if (itm.hasNext()) str.append("\n");
            }
            if (!str.toString().isEmpty()) {
                fw.write(str.toString());
            }
            System.out.println("Запись в файл '" + Paths.get(fileName).getFileName() + "' закончена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Логирование
    static void log(String str1) {
        try{
            //Скрок в файле
            int number = 50;
            // В первой строке файла будем записывать число строк в файле
            String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
            String fileName = src + "calc/log.txt";
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");

            //Определяем сколько строк содержит последовательность 'str1'
            String[] strMass = str1.trim().split("\\n");
            int srt1LenCount = strMass.length;
            String line1;
            int fileLenCount = (line1 = file.readLine()) != null
                    ? Integer.parseInt(line1.trim()) : 0;

            //Если сумма строк в файле и строке меньше или равно 50, прото добавляем новые строки
            if(srt1LenCount + fileLenCount <= number){
                StringBuilder strWrite = new StringBuilder();
                for (int i = 0; i < fileLenCount ; i++){
                    strWrite.append(new String(file.readLine().trim()
                            .getBytes("ISO-8859-1"), "UTF-8"));
                    strWrite.append("\n");
                }
                strWrite.append(str1);
                String temp = Integer.toString(srt1LenCount + fileLenCount) + "\n";
                file.seek(0);
                file.write(StandardCharsets.UTF_8.encode(temp).array());
                file.write(StandardCharsets.UTF_8.encode(strWrite.toString()).array());
            }
            //Иначе, если в строке меньше number, пропускаем столько же строк в файле остальные читаем
            // добавляем новые и пишем заново
            else if(srt1LenCount < number) {
                //file.seek(0);
                StringBuilder strWrite = new StringBuilder();
                for (int i = 0; i < fileLenCount ; i++){
                    String line2 = file.readLine().trim();
                    if(i >= srt1LenCount + fileLenCount - number) {
                        strWrite.append(new String(line2.getBytes("ISO-8859-1"), "UTF-8"));
                        strWrite.append("\n");
                    }
                }
                strWrite.append(str1);
                String temp = Integer.toString(number) + "\n";
                file.seek(0);
                file.write(StandardCharsets.UTF_8.encode(temp).array());
                file.write(StandardCharsets.UTF_8.encode(strWrite.toString()).array());
            }
            //Иначе, если новых строк больше number, пишем последние number
            else {
                StringBuilder strWrite = new StringBuilder();
                for (int i = (srt1LenCount - number); i < srt1LenCount; i++){
                    strWrite.append(strMass[i].trim());
                    if(i+1 < srt1LenCount) strWrite.append("\n");
                }
                String temp = Integer.toString(number) + "\n";
                file.seek(0);
                file.write(StandardCharsets.UTF_8.encode(temp).array());
                file.write(StandardCharsets.UTF_8.encode(strWrite.toString()).array());
            }
            file.close();
            //System.out.println("Запись в файл '" + Paths.get(fileName).getFileName() + "' закончена");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
