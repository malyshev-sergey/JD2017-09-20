package by.it.malyshev.calc.report;

import by.it.malyshev.calc.Depository;

public class LongReportBuilder extends ReportBuilder {

    @Override
    public void addHeader() {
        sb.delete(0, sb.length());
        sb.append("<!DOCTYPE html>\n<HTML>\n<HEAD>\n<META charset=\"utf-8\">\n");
        sb.append("<TITLE>Учебный проект Calc. Полный отчет</TITLE>\n");
        sb.append("<style type=\"text/css\">\nh2 {color: blue;}\nem {color: green;}\n" +
                ".colVar {font-size:80%}\n</style>\n</HEAD>\n<BODY>\n");
        sb.append("<H1>Учебный проект Calc. Полный отчет</H1>\n");
        report.setHeader(sb.toString());
    }

    @Override
    public void addProgramStartTime() {
        sb.delete(0, sb.length());
        sb.append("<p>Начало сессии: ");
        sb.append(dateFormat.format(Depository.programStartTime));
        sb.append("</p>\n");
        report.setProgramStartTime(sb.toString());
    }

    @Override
    public void addProgramFinishTime() {
        sb.delete(0, sb.length());
        sb.append("<p>Окончание сессии: ");
        sb.append(dateFormat.format(Depository.programFinishTime));
        sb.append("</p>\n");
        report.setProgramFinishTime(sb.toString());
    }

    @Override
    public void addOperations() {
        sb.delete(0, sb.length());
        sb.append("<hr>");
        sb.append("<h2>Выполненные операции</h2>\n");
        for (int i = 0; i < Depository.inputLines.size(); i++) {
            sb.append("<p>In: <em>");
            sb.append(Depository.inputLines.get(i));
            sb.append("</em><br>\nOut: <strong>");
            sb.append(Depository.outputLines.get(i));
            sb.append("</strong></p>\n");
        }
        sb.append("<hr>\n");
        report.setOperations(sb.toString());
    }

    @Override
    public void addFooter() {

        sb.delete(0, sb.length());
        sb.append("<h2>Сохраненная коллекция переменных</h2>\n<p class=\"colVar\">");
        for (String str : Depository.varColtoString())
            sb.append(str).append("<br>\n");
        sb.append("</p>\n<hr>\n<table width=\"100%\">\n<tr>\n");
        sb.append("<td align=\"left\"><a href=\"https://www.it-academy.by/\">IT-Academy</a></td>\n");
        sb.append("<td align=\"right\"><a href=\"https://github.com/malyshev-sergey/JD2017-09-20\">&copy; Sergey Malyshev</a></td>\n");
        sb.append("</tr>\n</table>\n</body>\n</html>\n");
        report.setFooter(sb.toString());
    }


}
