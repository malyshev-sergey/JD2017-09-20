package by.it.malyshev.calc.report;

import by.it.malyshev.calc.Depository;

public class ShortReportBuilder extends ReportBuilder {

    @Override
    public void addHeader() {
        report.setHeader("Учебный проект \"Calc\"\r\nКраткий отчет\r\n\r\n");
    }

    @Override
    public void addProgramStartTime() {
        report.setProgramStartTime("Начало сессии: " + dateFormat.format(Depository.programStartTime) + "\r\n");
    }

    @Override
    public void addProgramFinishTime() {
        report.setProgramFinishTime("Окончание сессии: " + dateFormat.format(Depository.programFinishTime) + "\r\n\r\n");
    }

    @Override
    public void addOperations() {
        for (int i = 0; i < Depository.inputLines.size(); i++) {
            sb.append("In: ");
            sb.append(Depository.inputLines.get(i));
            sb.append("\r\nOut: ");
            sb.append(Depository.outputLines.get(i));
            sb.append("\r\n");
        }
        report.setOperations(sb.toString());
    }

    @Override
    public void addFooter() {
        report.setFooter("");
    }

}

