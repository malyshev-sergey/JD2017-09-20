package by.it.malyshev.calc.report;

import java.text.SimpleDateFormat;

public abstract class ReportBuilder {

    Report report;

    Report getReport() { return report; }
    void createNewReport() { report = new Report(); }

    StringBuilder sb = new StringBuilder();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public abstract void addHeader();
    public abstract void addProgramStartTime();
    public abstract void addProgramFinishTime();
    public abstract void addOperations();
    public abstract void addFooter();

}
