package by.it.malyshev.calc.report;

public class Writer {

    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder rb) {
        reportBuilder = rb;
    }

    public Report getReport() {
        return reportBuilder.getReport();
    }

    public void constructReport() {
        reportBuilder.createNewReport();
        reportBuilder.addHeader();
        reportBuilder.addProgramStartTime();
        reportBuilder.addProgramFinishTime();
        reportBuilder.addOperations();
        reportBuilder.addFooter();
    }
}
