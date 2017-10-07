package by.it.likhanau.jd01_02;


public class Runner {
    public static void main(String[] args) {
        String line = Utils.getLine();
        TaskA taskA = new TaskA(line);
        taskA.searchMaxAndMinLengthNumber(line);
        taskA.searchNumbersWithDifferentDigits();
        taskA.searchUnderArithmeticalMeanNumbers();
    }
}
