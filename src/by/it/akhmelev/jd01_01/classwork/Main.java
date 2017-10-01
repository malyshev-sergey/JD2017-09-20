package by.it.akhmelev.jd01_01.classwork;

public class Main {

    public static void main(String[] args) {

        MySlogan mySlogan=new MySlogan();
        System.out.println(mySlogan.getSlogan());
        mySlogan.setSlogan("Hello 2");
        System.out.println(mySlogan.getSlogan());

        PrintArgs printArgs=new PrintArgs(args);
        printArgs.printArgs();
    }
}
