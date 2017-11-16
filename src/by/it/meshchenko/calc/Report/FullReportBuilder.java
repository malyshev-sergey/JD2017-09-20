package by.it.meshchenko.calc.Report;

public class FullReportBuilder extends ReportBuilder {

    public static StringBuilder report;

    static {
        report = new StringBuilder();
    }

    @Override
    public String header() {
        return "Полный отчёт работы калькулятора";
    }

    @Override
    public String body() {
        return FullReportBuilder.report.toString();
    }

    @Override
    public String getTimeStart() {
        return ReportBuilder.timeStart;
    }

    @Override
    public String getTimeEnd() {
        return ReportBuilder.timeEnd;
    }
}
