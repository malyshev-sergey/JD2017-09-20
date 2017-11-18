package by.it.shelkovich.calc.reports;

import by.it.shelkovich.calc.events.IVarEventListner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportDataCollector implements IVarEventListner {
    public long getStartTime() {
        return startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    private long startTime;
    private long stopTime;

    private List<String> msgs = new ArrayList<>();

    @Override
    public void doAction(String msg){
        msgs.add(msg);
    }

    public List<String> getMsgs(){
        return msgs;
    }

    public void saveStartTime(){
        startTime = new Date().getTime();
    }

    public void saveStopTime(){
        stopTime = new Date().getTime();
    }


}
