package by.it.shelkovich.calc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    static File logFile = new File(System.getProperty("user.dir") + "/src/by/it/shelkovich/calc/calcLog.txt");
    static List<String> logMsgs = new ArrayList<>();

    static void log(String msg) {
        if (logFile.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while((line = bufferedReader.readLine()) != null){
                    logMsgs.add(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logMsgs.add(msg);
        while(logMsgs.size()>50) logMsgs.remove(0);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile))) {
            for (String logMsg : logMsgs) {
                bufferedWriter.write(logMsg);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}