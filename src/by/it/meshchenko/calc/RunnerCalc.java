package by.it.meshchenko.calc;

import by.it.malyshev.jd01_03.InOut;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RunnerCalc {

    private static void printOneVar(String str, Var v) throws IOException{
        if (v!=null){
            System.out.println(str + v);
            InOutFile.log(str + " = " + v.toString());
        }
    }

    public static void main(String[ ] args)  throws IOException {

        //Переменные для тестирования операций +*-/
        String vec = "{1,2,3}";
        String matrix = "{{1,2,3},{4,5,6},{7,8,9}}";
        // Выражения для тестирования операций чтения и записи файла
        Expression ex1 = Parser.parseAssign("C=-9.5");
        Expression ex2 = Parser.parseAssign("A={1,2,3}");
        Expression ex3 = Parser.parseAssign("Z=0.5");
        Expression ex4 = Parser.parseAssign("B=-18.1");
        Expression ex5 = Parser.parseAssign("D={{1,2,3},{4,5,6},{7,8,9}}");
        LinkedHashMap<String, String> hs = new LinkedHashMap<String, String>() {
            {
                this.put(ex1.getName(), ex1.getStrValue());
                this.put(ex2.getName(), ex2.getStrValue());
                this.put(ex3.getName(), ex3.getStrValue());
                this.put(ex4.getName(), ex4.getStrValue());
                this.put(ex5.getName(), ex5.getStrValue());
            }
        };
        //Проверка работы записи файла
        InOutFile.write(hs);
        //Проверка работы чтения файла
        LinkedHashMap<String, String> hsF = InOutFile.read();
        if(hsF != null && hsF.size() > 0){
            System.out.println("printVar from File");
            Calc.printStringVar(hsF);
            System.out.println("sortVar from File");
            Calc.sortStringVar(hsF);
        }
        else {
            System.out.println("printVar");
            Calc.printStringVar(hs);
            System.out.println("sortVar");
            Calc.sortStringVar(hs);
        }

        //Проверка операций +*-/ с переменными Var
        // F F
        String opStr = "проверка +-*/ операций со скалярами";
        String strEx1 = "1+2";
        String strEx2 = "9-7";
        String strEx3 = "1.5*2";
        String strEx4 = "-4/(-1)";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarF("1").add(new VarF("2")));
//        printOneVar(new VarF("9").sub(new VarF("7")));
//        printOneVar(new VarF("1.5").mul(new VarF("2")));
//        printOneVar(new VarF("-4").div(new VarF("-1")));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // V F
        opStr = "проверка  +-*/ операций с векторами справа и скалярами слева";
        strEx1 = "{1,2,3}+2";
        strEx2 = "{-1,2,3}-7";
        strEx3 = "{1,2,3}*2";
        strEx4 = "{1,2,3}/0";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarV(vec).add(new VarF("2")));
//        printOneVar(new VarV(vec).sub(new VarF("7")));
//        printOneVar(new VarV(vec).mul(new VarF("2")));
//        printOneVar(new VarV(vec).div(new VarF("-1")));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // F V
        opStr = "проверка  +-*/ операций со скалярами справа и векторами слева";
        strEx1 = "1+{1,2,3}";
        strEx2 = "2-{1,2,3}";
        strEx3 = "1*{1,2,3}";
        strEx4 = "2/{1,2,3}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarF("1").add(new VarV(vec)));
//        printOneVar(new VarF("2").sub(new VarV(vec)));
//        printOneVar(new VarF("1").mul(new VarV(vec)));
//        printOneVar(new VarF("2").div(new VarV(vec)));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // V V
        opStr = "проверка  +-*/ операций с двумя векторами";
        strEx1 = "{1,2,3}+{1,2,3}";
        strEx2 = "{1,2,3}-{1,2,3}";
        strEx3 = "{1,2,3}*{1,2,3}";
        strEx4 = "{1,2,3}/{1,2,3}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarV(vec).add(new VarV(vec)));
//        printOneVar(new VarV(vec).sub(new VarV(vec)));
//        printOneVar(new VarV(vec).mul(new VarV(vec)));
//        printOneVar(new VarV(vec).div(new VarV(vec)));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // M F
        opStr = "проверка  +-*/ операций с матрицей справа и скалярами слева";
        strEx1 = "{{1,2,3},{4,5,6},{7,8,9}}+2";
        strEx2 = "{{1,2,3},{4,5,6},{7,8,9}}-7";
        strEx3 = "{{1,2,3},{4,5,6},{7,8,9}}*2";
        strEx4 = "{{1,2,3},{4,5,6},{7,8,9}}/(-1)";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarM(matrix).add(new VarF("2")));
//        printOneVar(new VarM(matrix).sub(new VarF("7")));
//        printOneVar(new VarM(matrix).mul(new VarF("2")));
//        printOneVar(new VarM(matrix).div(new VarF("-1")));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // F M
        opStr = "проверка  +-*/ операций со скалярами справа и матрицей слева";
        strEx1 = "1+{{1,2,3},{4,5,6},{7,8,9}}";
        strEx2 = "9-{{1,2,3},{4,5,6},{7,8,9}}";
        strEx3 = "1.5*{{1,2,3},{4,5,6},{7,8,9}}";
        strEx4 = "-4/{{1,2,3},{4,5,6},{7,8,9}}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarF("1").add(new VarM(matrix)));
//        printOneVar(new VarF("9").sub(new VarM(matrix)));
//        printOneVar(new VarF("1.5").mul(new VarM(matrix)));
//        printOneVar(new VarF("-4").div(new VarM(matrix)));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // M V
        opStr = "проверка  +-*/ операций с матрицей справа и вектором слева";
        strEx1 = "{{1,2,3},{4,5,6},{7,8,9}}+{1,2,3}";
        strEx2 = "{{1,2,3},{4,5,6},{7,8,9}}-{1,2,3}";
        strEx3 = "{{1,2,3},{4,5,6},{7,8,9}}*{1,2,3}";
        strEx4 = "{{1,2,3},{4,5,6},{7,8,9}}/{1,2,3}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarM(matrix).add(new VarV(vec)));
//        printOneVar(new VarM(matrix).sub(new VarV(vec)));
//        printOneVar(new VarM(matrix).mul(new VarV(vec)));
//        printOneVar(new VarM(matrix).div(new VarV(vec)));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // V M
        opStr = "проверка  +-*/ операций с вектором справа и матрицей слева";
        strEx1 = "{1,2,3}+{{1,2,3},{4,5,6},{7,8,9}}";
        strEx2 = "{1,2,3}-{{1,2,3},{4,5,6},{7,8,9}}";
        strEx3 = "{1,2,3}*{{1,2,3},{4,5,6},{7,8,9}}";
        strEx4 = "{1,2,3}/{{1,2,3},{4,5,6},{7,8,9}}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarV(vec).add(new VarM(matrix)));
//        printOneVar(new VarV(vec).sub(new VarM(matrix)));
//        printOneVar(new VarV(vec).mul(new VarM(matrix)));
//        printOneVar(new VarV(vec).div(new VarM(matrix)));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));

        // M M
        opStr = "проверка  +-*/ операций с двумя матрицами";
        strEx1 = "{{1,2,3},{4,5,6},{7,8,9}}+{{1,2,3},{4,5,6},{7,8,9}}";
        strEx2 = "{{1,2,3},{4,5,6},{7,8,9}}-{{1,2,3},{4,5,6},{7,8,9}}";
        strEx3 = "{{1,2,3},{4,5,6},{7,8,9}}*{{1,2,3},{4,5,6},{7,8,9}}";
        strEx4 = "{{1,2,3},{4,5,6},{7,8,9}}/{{1,2,3},{4,5,6},{7,8,9}}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
//        printOneVar(new VarM(matrix).add(new VarM(matrix)));
//        printOneVar(new VarM(matrix).sub(new VarM(matrix)));
//        printOneVar(new VarM(matrix).mul(new VarM(matrix)));
//        printOneVar(new VarM(matrix).div(new VarM(matrix)));
        printOneVar(strEx1, Calc.calculate(Parser.parseEx(strEx1)));
        printOneVar(strEx2, Calc.calculate(Parser.parseEx(strEx2)));
        printOneVar(strEx3, Calc.calculate(Parser.parseEx(strEx3)));
        printOneVar(strEx4, Calc.calculate(Parser.parseEx(strEx4)));
    }
}
