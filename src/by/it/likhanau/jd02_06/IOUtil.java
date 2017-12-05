package by.it.likhanau.jd02_06;


import java.io.*;
import java.util.Date;

public class IOUtil {
    public static void writeInTheFile(String message){
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/by/it/likhanau/jd02_06/log.txt", true))) {
        Date date = new Date();
            bufferedWriter.write(message + " - " + date.toString());
            bufferedWriter.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }


    }
}
