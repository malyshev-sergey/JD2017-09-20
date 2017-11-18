package by.it.shelkovich.calc;

import by.it.shelkovich.calc.Vars.VarFileIO;
import by.it.shelkovich.calc.Vars.VarStorage;
import by.it.shelkovich.calc.events.EventProducer;
import by.it.shelkovich.calc.reports.*;

public class CalcRunner {
    public static void main(String[] args) {
        ReportDataCollector collector = new ReportDataCollector();
        EventProducer.INSTANCE.addListner(collector);
        EventProducer.INSTANCE.addListner(Logger.INSTANCE);
        collector.saveStartTime();

        VarFileIO varFile = new VarFileIO();
        varFile.loadFromFile();



        Parser parser = new Parser();

        try {

            System.out.println(parser.calc("1.5/2.1+1"));
            System.out.println(parser.calc("A=2+5.3"));
            System.out.println(parser.calc("B=A*3.5"));
            System.out.println(parser.calc("B1=B+0.11*-5"));
            System.out.println(parser.calc("B2=A/2-1"));

            System.out.println(parser.calc("C=B+(A*2)"));
            System.out.println(parser.calc("D=((C-0.15)-20)/(7-5)"));
            System.out.println(parser.calc("E={2,3}*(D/2)"));

        }catch (ArithmeticException e){
            //Logger.INSTANCE.log(e.getMessage());
            EventProducer.INSTANCE.notifyListners(e.getMessage());
            e.printStackTrace();
        }
        
        VarStorage.printVars();
        VarStorage.sortVars();

        varFile.saveToFile();

        collector.saveStopTime();

        Reporter reporter = new Reporter(new ShortReportBuilder(), collector);
        ReportPrinter repPrinter = new ReportPrinter(reporter.buildReport());
        repPrinter.print();

        reporter.setBuilder(new FullReportBuilder());
        repPrinter.setReport(reporter.buildReport());
        repPrinter.print();

    }
}
