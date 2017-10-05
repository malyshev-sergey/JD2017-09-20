package by.it.akhmelev.jd01_07._01_Interface;

public class Runner {
    public static void main(String[] args) {
        IBaseAction base=new IBaseImplementation();
        base.blocking();
        //...
        base.unBlocking();
    }
}
