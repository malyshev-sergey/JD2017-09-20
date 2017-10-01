package by.it.akhmelev.jd01_01.classwork;

public class PrintArgs {

    String[] args;

    public PrintArgs(String[] args2) {
        this.args=args2;
    }

    public void printArgs(){
        for (String s:args)
            System.out.println(s);
    }

}
