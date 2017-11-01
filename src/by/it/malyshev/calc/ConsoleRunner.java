package by.it.malyshev.calc;

public class ConsoleRunner {

    private static void printOneVar(Var v) {
        if (v != null) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {

        printOneVar(Parser.singleOperation("-1+2"));
        printOneVar(Parser.singleOperation("-9-7"));

        printOneVar(Parser.singleOperation("-1.5*-2"));
        printOneVar(Parser.singleOperation("-1.5*2"));
        printOneVar(Parser.singleOperation("1.5*2"));
        printOneVar(Parser.singleOperation("-4/-1"));
        printOneVar(Parser.singleOperation("-4/2"));
        printOneVar(Parser.singleOperation("4/2"));
        try {
            printOneVar(Parser.singleOperation("4/0"));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }


        printOneVar(Parser.singleOperation("4 1"));
        printOneVar(Parser.singleOperation("{-1,2,3}+{1,2,3}"));
        try {

            printOneVar(Parser.singleOperation("{-1,2,3}*{1,2}"));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        printOneVar(Parser.singleOperation("{{1,2},{8,3}}*{{1,2},{8,3}}"));
        System.out.println();
        printOneVar(Parser.fromString("A = " + Parser.singleOperation("-1+2")));
        printOneVar(Parser.fromString("B  " + Parser.singleOperation("4-1")));
        printOneVar(Parser.fromString("A2 = " + Parser.singleOperation("4-1")));
        printOneVar(Parser.fromString("A1 = " + Parser.singleOperation("{1,2,3}+{4,5,6}")));
        printOneVar(Parser.fromString("C = " + Parser.singleOperation("{{-1,2},{8,-3}}*{{-1,2},{8,-3}}")));
        printOneVar(Parser.fromString("D = " + Parser.singleOperation("-28+{{-1,2},{8,-3}}")));
        printOneVar(Parser.fromString("E = " + Parser.singleOperation("{{-1,2},{8,-3}}+3")));
        printOneVar(Parser.fromString("F = " + Parser.singleOperation("28+{1,2,3}")));
        printOneVar(Parser.fromString("G = " + Parser.singleOperation("{{-1,2},{8,-3}}-3")));
        printOneVar(Parser.fromString("H = " + Parser.singleOperation("3-{{-1,2},{8,-3}}")));
        printOneVar(Parser.fromString("K = {{-1,2},{8,-3}}-3"));
        printOneVar(Parser.fromString("L = 3-{{-1,2},{8,-3}}"));
        printOneVar(Parser.fromString("M = {{-1,2},{8,-3}}"));
        printOneVar(Parser.fromString("K = {{-1,2},{8,-3}}/0"));
        printOneVar(Parser.fromString("K = {{-1,2},{8,-3}}*{{-1,2},{8,-3},{8,-3}}"));
        printOneVar(Parser.fromString("K = {{-1,2},{8,-3}}*{-1,2}"));
        printOneVar(Parser.fromString("K = {{-1,2},{8,-3}}*{-1,2,5}"));



        Parser.fromString("printvar");
        Parser.fromString("sortvar");


//        System.out.println("\nпроверка +-*/ операций со скалярами");
//        printOneVar(new VarD("1").add(new VarD("2")));
//        printOneVar(new VarD("9").sub(new VarD("7")));
//        printOneVar(new VarD("1.5").mul(new VarD("2")));
//        printOneVar(new VarD("-4").div(new VarD("-1")));
//
//
//        String vec="{1,2,3}";
//        String vec2="{1,2}";
//
//        System.out.println("\nпроверка  +-*/ операций с векторами слева и скалярами справа");
//        printOneVar(new VarV(vec).add(new VarD("2")));
//        printOneVar(new VarV(vec).sub(new VarD("1")));
//        printOneVar(new VarV(vec).mul(new VarD("2")));
//        printOneVar(new VarV(vec).div(new VarD("1")));
//
//        System.out.println("\nпроверка  +-*/ операций со скалярами слева и векторами справа");
//        printOneVar(new VarD("1").add(new VarV(vec)));
//        printOneVar(new VarD("2").sub(new VarV(vec)));
//        printOneVar(new VarD("1").mul(new VarV(vec)));
//        printOneVar(new VarD("2").div(new VarV(vec)));
//
//        System.out.println("\nпроверка  +-*/ операций с двумя векторами");
//        printOneVar(new VarV(vec).add(new VarV(vec)));
//        printOneVar(new VarV(vec).sub(new VarV(vec)));
//        printOneVar(new VarV(vec).mul(new VarV(vec)));
//        printOneVar(new VarV(vec).div(new VarV(vec)));
//
//        System.out.println("\nпроверка  +-*/ операций с двумя векторами c разной размерностью");
//        printOneVar(new VarV(vec).add(new VarV(vec2)));
//        printOneVar(new VarV(vec).sub(new VarV(vec2)));
//        printOneVar(new VarV(vec).mul(new VarV(vec2)));
//        printOneVar(new VarV(vec).div(new VarV(vec2)));
//
//        String mat="{{1,2},{8,3}}";
//        vec="{1,2}";
//        String mat2="{{1,2,3},{8,4,5},{4,5,6}}";
//
//        System.out.println("\nпроверка  +-*/ операций с матрицами слева и скалярами справа");
//        printOneVar(new VarM(mat).add(new VarD("2")));
//        printOneVar(new VarM(mat).sub(new VarD("1")));
//        printOneVar(new VarM(mat).mul(new VarD("2")));
//        printOneVar(new VarM(mat).div(new VarD("1")));
//
//        System.out.println("\nпроверка  +-*/ операций со скалярами слева и матрицами справа");
//        printOneVar(new VarD("1").add(new VarM(mat)));
//        printOneVar(new VarD("2").sub(new VarM(mat)));
//        printOneVar(new VarD("1").mul(new VarM(mat)));
//        printOneVar(new VarD("2").div(new VarM(mat)));
//
//
//        System.out.println("\nпроверка  +-*/ операций с матрицами сдева и векторами справа");
//        printOneVar(new VarM(mat).add(new VarV(vec)));
//        printOneVar(new VarM(mat).sub(new VarV(vec)));
//        printOneVar(new VarM(mat).mul(new VarV(vec)));
//        printOneVar(new VarM(mat).div(new VarV(vec)));
//
//        System.out.println("\nпроверка  +-*/ операций с матрицами сдева и векторами справа с разной размерностью");
//        printOneVar(new VarM(mat2).add(new VarV(vec)));
//        printOneVar(new VarM(mat2).sub(new VarV(vec)));
//        printOneVar(new VarM(mat2).mul(new VarV(vec)));
//        printOneVar(new VarM(mat2).div(new VarV(vec)));
//
//        System.out.println("\nпроверка  +-*/ операций с матрицами справа и векторами слева");
//        printOneVar(new VarV(vec).add(new VarM(mat)));
//        printOneVar(new VarV(vec).sub(new VarM(mat)));
//        printOneVar(new VarV(vec).mul(new VarM(mat)));
//        printOneVar(new VarV(vec).div(new VarM(mat)));
//
//        System.out.println("\nпроверка  +-*/ операций с матрицами справа и векторами слева с разной размерностью");
//        printOneVar(new VarV(vec).add(new VarM(mat2)));
//        printOneVar(new VarV(vec).sub(new VarM(mat2)));
//        printOneVar(new VarV(vec).mul(new VarM(mat2)));
//        printOneVar(new VarV(vec).div(new VarM(mat2)));
//
//        System.out.println("\nпроверка  +-*/ операций с двумя матрицами");
//        printOneVar(new VarM(mat).add(new VarM(mat)));
//        printOneVar(new VarM(mat).sub(new VarM(mat)));
//        printOneVar(new VarM(mat).mul(new VarM(mat)));
//        printOneVar(new VarM(mat).div(new VarM(mat)));
//
//        System.out.println("\nпроверка  +-*/ операций с двумя матрицами с разной размерностью");
//        printOneVar(new VarM(mat).add(new VarM(mat2)));
//        printOneVar(new VarM(mat).sub(new VarM(mat2)));
//        printOneVar(new VarM(mat).mul(new VarM(mat2)));
//        printOneVar(new VarM(mat).div(new VarM(mat2)));


    }


}
