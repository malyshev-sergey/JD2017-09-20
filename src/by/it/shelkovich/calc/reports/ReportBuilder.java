package by.it.shelkovich.calc.reports;

public abstract class ReportBuilder {

    Report report;
    ReportDataCollector data;

    Report getReport(){
        return report;
    }
    void createNewReport(){
        report = new Report();
    }

    public void setData(ReportDataCollector data) {
        this.data = data;
    }

    public abstract void fillHeader();
    public abstract void fillStartStopTime();
    public abstract void fillBody();
}
