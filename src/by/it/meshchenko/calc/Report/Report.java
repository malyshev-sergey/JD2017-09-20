package by.it.meshchenko.calc.Report;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.Date;

public class Report {

    ReportBuilder reportBuilder;

    public Report(ReportBuilder reportBuilder){
        this.reportBuilder = reportBuilder;
    }

    public void buildReport() throws IOException {
        try{
            String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
            String fileName = src + "calc/Report/report.txt";

            RandomAccessFile file = new RandomAccessFile(fileName, "rw");

            StringBuilder strWrite = new StringBuilder();
            strWrite.append(reportBuilder.header() + "\n");
            strWrite.append("Время запуска работы пакета " + reportBuilder.getTimeStart() + "\n");
            strWrite.append("Время завершения работы пакета " + reportBuilder.getTimeEnd() + "\n");
            strWrite.append(reportBuilder.body());
            System.out.println(strWrite);
            file.write(StandardCharsets.UTF_8.encode(strWrite.toString()).array());

            file.close();
            //System.out.println("Запись в файл '" + Paths.get(fileName).getFileName() + "' закончена");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
