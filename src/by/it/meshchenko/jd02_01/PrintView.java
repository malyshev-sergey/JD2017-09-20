package by.it.meshchenko.jd02_01;

public class PrintView {
    private int time;
    private int countBuyer;
    private String[] cashiers = new String[5];
    private boolean isCashier;
    private int queueSize;
    private double total;
    private String buyerState;

    PrintView(){
        this.time = -1;
        this.countBuyer = -1;
        for(int i = 0; i < cashiers.length; i++) this.cashiers[i] = "";
        this.isCashier = false;
        this.queueSize = -1;
        this.total = -1;
        this.buyerState = "";
    }

    public int getTime() {
        return time;
    }

    public int getCountBuyer() {
        return countBuyer;
    }

    public String getCashiers(int i) {
        return this.cashiers[i];
    }

    public int getQueueSize() {
        return queueSize;
    }

    public double getTotal() {
        return total;
    }

    public String getBuyerState() {
        return buyerState;
    }

    public boolean isCashier() {
        return isCashier;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCountBuyer(int countBuyer) {
        this.countBuyer = countBuyer;
    }

    public void setCashiers(int i, String c1) {
        this.cashiers[i] = c1;
        this.isCashier = true;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public void setTotal(double sum) {
        this.total = sum;
    }

    public void setBuyerState(String buyerState) {
        this.buyerState = buyerState;
    }
}
