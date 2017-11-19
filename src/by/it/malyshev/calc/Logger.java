package by.it.malyshev.calc;

import java.io.*;
import java.util.LinkedList;

class Logger {

    private static Logger instance;
    private File logFile = new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/out/log.txt");
    private LinkedList<String> logList = new LinkedList<>();


    private Logger() {
    }

    static Logger getLogger() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    void logWrite(String str) {
        logList.clear();
        if (logFile.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    logList.addLast(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logList.addLast(str);
        File logDir = new File(System.getProperty("user.dir") + "/src/by/it/malyshev/calc/out");
        if(!logDir.exists())
            if(!logDir.mkdir()) return;
        while (logList.size() > 50) logList.pop();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile))) {
            for (String v : logList) {
                bufferedWriter.write(v);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
