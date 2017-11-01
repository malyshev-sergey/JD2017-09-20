package by.it.akhmelev.calc;

public class ConsoleRunner {

    public static void main(String[] args) {
        Parser.calc("2+2");
        Parser.calc("2*2");
        Parser.calc("2/2");
        Parser.calc("2-2");
        Parser.calc("{1,2}+2");
        Parser.calc("{1,2}*2");
        Parser.calc("{1,2}/2");
        Parser.calc("{1,2}-2");

        Parser.calc("2+{1,2}");
        Parser.calc("2-{1,2}");
        Parser.calc("2*{1,2}");
        Parser.calc("2-{1,2}");

        Parser.calc("{{1,2},{3,4}}+6");
        Parser.calc("{{1,2},{3,4}}-6");
        Parser.calc("{{1,2},{3,4}}*6");
        Parser.calc("{{1,2},{3,4}}/6");

        Parser.calc("A=9");
        Parser.calc("B={3,5}");
    }
}
