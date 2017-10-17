package by.it.malyshev.calc;

public class ConsoleRunner {

    private static void printOneVar(Var v){
        if (v != null) {
            System.out.println(v);
        }
    }

    public static void main(String[ ] args) {

        printOneVar(Parser.fromString("-1+2"));
        printOneVar(Parser.fromString("-9-7"));
        printOneVar(Parser.fromString("-1.5*-2"));
        printOneVar(Parser.fromString("-1.5*2"));
        printOneVar(Parser.fromString("1.5*2"));
        printOneVar(Parser.fromString("-4/-1"));
        printOneVar(Parser.fromString("-4/2"));
        printOneVar(Parser.fromString("4/2"));

        printOneVar(Parser.fromString("4 1"));
        printOneVar(Parser.fromString("{-1,2,3}+{1,2,3}"));
        printOneVar(Parser.fromString("{{1,2},{8,3}}*{{1,2},{8,3}}"));

        Parser.fromString("A = "+ Parser.fromString("-1+2"));
        Parser.fromString("A2  "+ Parser.fromString("4-1"));
        Parser.fromString("A2 = "+ Parser.fromString("4-1"));
        Parser.fromString("A1 = "+ Parser.fromString("{1,2,3}+{4,5,6}"));
        Parser.fromString("C = "+ Parser.fromString("{{-1,2},{8,-3}}*{{-1,2},{8,-3}}"));
        Parser.fromString("D = "+ Parser.fromString("-28+{{-1,2},{8,-3}}"));
        Parser.fromString("E = "+ Parser.fromString("{{-1,2},{8,-3}}+3"));
        Parser.fromString("F = "+ Parser.fromString("28+{1,2,3}"));
// вычитание с матрицами и векторами пока не реализовано
        Parser.fromString("E = "+ Parser.fromString("{{-1,2},{8,-3}}-3"));
        Parser.fromString("E = "+ Parser.fromString("3-{{-1,2},{8,-3}}"));


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
