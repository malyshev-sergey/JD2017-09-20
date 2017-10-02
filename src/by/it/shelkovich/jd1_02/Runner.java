package by.it.shelkovich.jd1_02;

public class Runner {
    public static void main(String[] args) {
        TaskA taskA = new TaskA(Util.readLine());
        taskA.printLongestShortest();
        taskA.printLessThanAverage();
        taskA.printDiffDigitNumber();
    }
}
