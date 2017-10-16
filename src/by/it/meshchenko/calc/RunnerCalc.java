package by.it.meshchenko.calc;

public class RunnerCalc {
    private static void printOneVar(Var v){
        if (v!=null) System.out.println(v);
    }
    public static void main(String[ ] args) {
        //вместо парсера ввода в DEMO использовано создание готовых объектов из строк
        //в реальном решении еще нужно программно определить тип объекта
        String vec = "{1,2,3}";
        String matrix = "{{1,2,3},{4,5,6},{7,8,9}}";

        // F F
        System.out.println("\nпроверка +-*/ операций со скалярами");
        printOneVar(new VarF("1").add(new VarF("2")));
        printOneVar(new VarF("9").sub(new VarF("7")));
        printOneVar(new VarF("1.5").mul(new VarF("2")));
        printOneVar(new VarF("-4").div(new VarF("-1")));

        // V F
        System.out.println("\nпроверка  +-*/ операций с векторами справа и скалярами слева");
        printOneVar(new VarV(vec).add(new VarF("2")));
        printOneVar(new VarV(vec).sub(new VarF("1")));
        printOneVar(new VarV(vec).mul(new VarF("2")));
        printOneVar(new VarV(vec).div(new VarF("1")));

        // F V
        System.out.println("\nпроверка  +-*/ операций со скалярами справа и векторами слева");
        printOneVar(new VarF("1").add(new VarV(vec)));
        printOneVar(new VarF("2").sub(new VarV(vec)));
        printOneVar(new VarF("1").mul(new VarV(vec)));
        printOneVar(new VarF("2").div(new VarV(vec)));

        // V V
        System.out.println("\nпроверка  +-*/ операций с двумя векторами");
        printOneVar(new VarV(vec).add(new VarV(vec)));
        printOneVar(new VarV(vec).sub(new VarV(vec)));
        printOneVar(new VarV(vec).mul(new VarV(vec)));
        printOneVar(new VarV(vec).div(new VarV(vec)));

        // M F
        System.out.println("\nпроверка  +-*/ операций с матрицей справа и скалярами слева");
        printOneVar(new VarM(matrix).add(new VarF("2")));
        printOneVar(new VarM(matrix).sub(new VarF("7")));
        printOneVar(new VarM(matrix).mul(new VarF("2")));
        printOneVar(new VarM(matrix).div(new VarF("-1")));

        // F M
        System.out.println("\nпроверка  +-*/ операций со скалярами справа и матрицей слева");
        printOneVar(new VarF("1").add(new VarM(matrix)));
        printOneVar(new VarF("9").sub(new VarM(matrix)));
        printOneVar(new VarF("1.5").mul(new VarM(matrix)));
        printOneVar(new VarF("-4").div(new VarM(matrix)));

        // M V
        System.out.println("\nпроверка  +-*/ операций с матрицей справа и вектором слева");
        printOneVar(new VarM(matrix).add(new VarV(vec)));
        printOneVar(new VarM(matrix).sub(new VarV(vec)));
        printOneVar(new VarM(matrix).mul(new VarV(vec)));
        printOneVar(new VarM(matrix).div(new VarV(vec)));

        // V M
        System.out.println("\nпроверка  +-*/ операций с вектором справа и матрицей слева");
        printOneVar(new VarV(vec).add(new VarM(matrix)));
        printOneVar(new VarV(vec).sub(new VarM(matrix)));
        printOneVar(new VarV(vec).mul(new VarM(matrix)));
        printOneVar(new VarV(vec).div(new VarM(matrix)));

        // M M
        System.out.println("\nпроверка  +-*/ операций с двумя матрицами");
        printOneVar(new VarM(matrix).add(new VarM(matrix)));
        printOneVar(new VarM(matrix).sub(new VarM(matrix)));
        printOneVar(new VarM(matrix).mul(new VarM(matrix)));
        printOneVar(new VarM(matrix).div(new VarM(matrix)));

    }
}
