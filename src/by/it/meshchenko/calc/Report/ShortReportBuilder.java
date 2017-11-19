package by.it.meshchenko.calc.Report;

public class ShortReportBuilder extends ReportBuilder {

    public static StringBuilder report;

    static {
        report = new StringBuilder();
    }

    @Override
    public String header() {
        return "Краткий отчёт работы калькулятора";
    }

    @Override
    public String body() {
        return ShortReportBuilder.report.toString();
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
