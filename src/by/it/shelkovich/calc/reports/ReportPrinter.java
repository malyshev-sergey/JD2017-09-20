package by.it.shelkovich.calc.reports;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.List;

public class ReportPrinter {
    private Report report;

    public ReportPrinter(Report rep){
        report = rep;
    }

    public void setReport(Report rep){
        report = rep;
    }
    public void print(){
        System.out.println(report.getHead());
        System.out.println(report.getStartTime());
        System.out.println(report.getEndTime());
        System.out.println("Произошедшие события:");
        for(String msg: report.getMessages()){
            System.out.println(msg);
        }
    }
}
