package by.it.meshchenko.jd02_06;

import by.it.meshchenko.Util.Util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {
    private static volatile Logger instance;
    private static final Lock lockLogger = new ReentrantLock();

    private Logger(){}

    public static Logger getInstance(){
        Logger localInstance = instance;
        if(localInstance == null){
            try{
                lockLogger.lock();
                localInstance = instance;
                if(localInstance == null){
                    instance = localInstance = new Logger();
                }
            }
            finally {
                lockLogger.unlock();
            }
        }
        return localInstance;
    }

    //Логирование: 50 последних сообщений
    public void writeError(String str1) {
        //Скрок в файле
        int number = 50;
        DateFormat df = DateFormat.getDateTimeInstance(3, 2, Locale.FRANCE);
        Date d = new Date();
        try{
            //Определяем сколько строк содержит последовательность 'str1'
            String[] strMass = str1.trim().split("\\n");
            int srt1LenCount = strMass.length;
            // Добавляем к каждой строке дату и время
            for (int i = 0; i < srt1LenCount; i++){
                strMass[i] = df.format(d) + " - " + strMass[i];
            }

            lockLogger.lock();

            // В первой строке файла будем записывать число строк в файле
            String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
            String fileName = src + "jd02_06/log.txt";
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");



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
                //strWrite.append(str1);
                for (int i = 0; i < srt1LenCount; i++){
                    strWrite.append(strMass[i].trim());
                    if(i+1 < srt1LenCount) strWrite.append("\n");
                }
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
                //strWrite.append(str1);
                for (int i = 0; i < srt1LenCount; i++){
                    strWrite.append(strMass[i].trim());
                    if(i+1 < srt1LenCount) strWrite.append("\n");
                }
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
            System.out.println("Запись в файл '" + Paths.get(fileName).getFileName() + "' закончена");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            lockLogger.unlock();
        }
    }
}
