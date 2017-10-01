package by.it.akhmelev.jd01_02.classwork;


public class Runner {

    public static void main(String[] args) {
        //String line = Utils.getMyOneLine();
        String line="111 232 34565 456 78";
        TaskA taskA=new TaskA(line);
        taskA.solveTaskA1(line);
        taskA.solveTaskA2();
        taskA.SolveTaskA3();

        String month="7";
        TaskB taskB=new TaskB(month);
    }
}
