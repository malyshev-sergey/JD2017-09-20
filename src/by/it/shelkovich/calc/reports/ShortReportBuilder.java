package by.it.shelkovich.calc.reports;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShortReportBuilder extends ReportBuilder {
    @Override
    public void fillHeader() {
        report.setHead("\n\nСокращённый отчёт");
    }

    @Override
    public void fillStartStopTime() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT);

        report.setStartTime("Нач. вып.: "+df.format(new Date(data.getStartTime()))+" "+tf.format(new Date(data.getStartTime())));
        report.setEndTime("Кон. вып.: "+df.format(new Date(data.getStopTime()))+" "+tf.format(new Date(data.getStopTime())));
    }

    @Override
    public void fillBody() {
        List<String> msgs = new ArrayList<>();
        for(String msg: data.getMsgs()){
            msg = msg.replace("\nresult:", " res: ");
            msg = msg.substring(msg.indexOf("ing:")+4, msg.length());
            msgs.add(msg);
        }
        report.setMessages(msgs);
    }
}
