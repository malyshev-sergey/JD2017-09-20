package by.it.shelkovich.calc.reports;

import by.it.shelkovich.calc.events.IVarEventListner;

public class Reporter {

    private ReportBuilder builder;
    private ReportDataCollector collector;

    public Reporter(ReportBuilder builder, ReportDataCollector collector){
        this.builder = builder;
        this.collector = collector;
    }

    public void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    public void setCollector(ReportDataCollector collector) {
        this.collector = collector;
    }

    public Report buildReport(){
        builder.createNewReport();
        builder.setData(collector);
        builder.fillHeader();
        builder.fillStartStopTime();
        builder.fillBody();
        return builder.getReport();
    }
}
