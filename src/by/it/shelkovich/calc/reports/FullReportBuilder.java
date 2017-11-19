package by.it.shelkovich.calc.reports;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FullReportBuilder extends ReportBuilder {
    @Override
    public void fillHeader() {
        report.setHead("\n\nПолный отчёт");
    }

    @Override
    public void fillStartStopTime() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.FULL);

        report.setStartTime("Начало выполнения: "+df.format(new Date(data.getStartTime()))+" "+tf.format(new Date(data.getStartTime())));
        report.setEndTime("Конец выполнения: "+df.format(new Date(data.getStopTime()))+" "+tf.format(new Date(data.getStopTime())));
    }

    @Override
    public void fillBody() {
        report.setMessages(data.getMsgs());
    }
}
