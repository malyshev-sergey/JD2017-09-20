package by.it.malyshev.calc.report;

public class Report {

    private String header = "";
    private String programStartTime = "";
    private String programFinishTime = "";
    private String operations = "";
    private String footer = "";

    void setHeader(String header) {
        this.header = header;
    }

    void setProgramStartTime(String programStartTime) {
        this.programStartTime = programStartTime;
    }

    void setProgramFinishTime(String programFinishTime) {
        this.programFinishTime = programFinishTime;
    }

    void setOperations(String operations) {
        this.operations = operations;
    }

    void setFooter(String footer) {
        this.footer = footer;
    }


    @Override
    public String toString() {
        return header + programStartTime + programFinishTime + operations + footer;
    }

}
