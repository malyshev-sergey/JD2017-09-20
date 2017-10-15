package by.it.malyshev.calc;

public class ConsoleRunner {

    private static void printOneVar(Var v){
        if (v != null) {
            System.out.println(v);
        }
    }

    public static void main(String[ ] args) {
        //вместо парсера ввода в DEMO использовано создание готовых объектов из строк
        //в реальном решении еще нужно программно определить тип объекта
        System.out.println("\nпроверка +-*/ операций со скалярами");
        printOneVar(new VarD("1").add(new VarD("2")));
        printOneVar(new VarD("9").sub(new VarD("7")));
        printOneVar(new VarD("1.5").mul(new VarD("2")));
        printOneVar(new VarD("-4").div(new VarD("-1")));

        String vec="{1,2,3}";
        String vec2="{1,2}";

        System.out.println("\nпроверка  +-*/ операций с векторами слева и скалярами справа");
        printOneVar(new VarV(vec).add(new VarD("2")));
        printOneVar(new VarV(vec).sub(new VarD("1")));
        printOneVar(new VarV(vec).mul(new VarD("2")));
        printOneVar(new VarV(vec).div(new VarD("1")));

        System.out.println("\nпроверка  +-*/ операций со скалярами слева и векторами справа");
        printOneVar(new VarD("1").add(new VarV(vec)));
        printOneVar(new VarD("2").sub(new VarV(vec)));
        printOneVar(new VarD("1").mul(new VarV(vec)));
        printOneVar(new VarD("2").div(new VarV(vec)));

        System.out.println("\nпроверка  +-*/ операций с двумя векторами");
        printOneVar(new VarV(vec).add(new VarV(vec)));
        printOneVar(new VarV(vec).sub(new VarV(vec)));
        printOneVar(new VarV(vec).mul(new VarV(vec)));
        printOneVar(new VarV(vec).div(new VarV(vec)));

        System.out.println("\nпроверка  +-*/ операций с двумя векторами c разной размерностью");
        printOneVar(new VarV(vec).add(new VarV(vec2)));
        printOneVar(new VarV(vec).sub(new VarV(vec2)));
        printOneVar(new VarV(vec).mul(new VarV(vec2)));
        printOneVar(new VarV(vec).div(new VarV(vec2)));

        String mat="{{1,2},{8,3}}";
        vec="{1,2}";
        String mat2="{{1,2,3},{8,4,5},{4,5,6}}";

        System.out.println("\nпроверка  +-*/ операций с матрицами слева и скалярами справа");
        printOneVar(new VarM(mat).add(new VarD("2")));
        printOneVar(new VarM(mat).sub(new VarD("1")));
        printOneVar(new VarM(mat).mul(new VarD("2")));
        printOneVar(new VarM(mat).div(new VarD("1")));

        System.out.println("\nпроверка  +-*/ операций со скалярами слева и матрицами справа");
        printOneVar(new VarD("1").add(new VarM(mat)));
        printOneVar(new VarD("2").sub(new VarM(mat)));
        printOneVar(new VarD("1").mul(new VarM(mat)));
        printOneVar(new VarD("2").div(new VarM(mat)));


        System.out.println("\nпроверка  +-*/ операций с матрицами сдева и векторами справа");
        printOneVar(new VarM(mat).add(new VarV(vec)));
        printOneVar(new VarM(mat).sub(new VarV(vec)));
        printOneVar(new VarM(mat).mul(new VarV(vec)));
        printOneVar(new VarM(mat).div(new VarV(vec)));

        System.out.println("\nпроверка  +-*/ операций с матрицами сдева и векторами справа с разной размерностью");
        printOneVar(new VarM(mat2).add(new VarV(vec)));
        printOneVar(new VarM(mat2).sub(new VarV(vec)));
        printOneVar(new VarM(mat2).mul(new VarV(vec)));
        printOneVar(new VarM(mat2).div(new VarV(vec)));

        System.out.println("\nпроверка  +-*/ операций с матрицами справа и векторами слева");
        printOneVar(new VarV(vec).add(new VarM(mat)));
        printOneVar(new VarV(vec).sub(new VarM(mat)));
        printOneVar(new VarV(vec).mul(new VarM(mat)));
        printOneVar(new VarV(vec).div(new VarM(mat)));

        System.out.println("\nпроверка  +-*/ операций с матрицами справа и векторами слева с разной размерностью");
        printOneVar(new VarV(vec).add(new VarM(mat2)));
        printOneVar(new VarV(vec).sub(new VarM(mat2)));
        printOneVar(new VarV(vec).mul(new VarM(mat2)));
        printOneVar(new VarV(vec).div(new VarM(mat2)));

        System.out.println("\nпроверка  +-*/ операций с двумя матрицами");
        printOneVar(new VarM(mat).add(new VarM(mat)));
        printOneVar(new VarM(mat).sub(new VarM(mat)));
        printOneVar(new VarM(mat).mul(new VarM(mat)));
        printOneVar(new VarM(mat).div(new VarM(mat)));

        System.out.println("\nпроверка  +-*/ операций с двумя матрицами с разной размерностью");
        printOneVar(new VarM(mat).add(new VarM(mat2)));
        printOneVar(new VarM(mat).sub(new VarM(mat2)));
        printOneVar(new VarM(mat).mul(new VarM(mat2)));
        printOneVar(new VarM(mat).div(new VarM(mat2)));

    }


//    public static void main(String[] args) {
//        Var v1=new VarD(3.8);
//        Var v2=new VarD(26.2);
//        System.out.println("v1="+v1+" v2="+v2);
//        Var v3=v1.add(v2);
//        print(v3);
//
//        v1=new VarD(87.4);
//        v2=new VarD(23.1);
//        System.out.println("v1="+v1+" v2="+v2);
//        v3=v1.sub(v2);
//        print(v3);
//
//        v1=new VarD(1.04);
//        v2=new VarD(5.9);
//        System.out.println("v1="+v1+" v2="+v2);
//        v3=v1.mul(v2);
//        print(v3);
//
//        v1=new VarD(12.7);
//        v2=new VarD(5);
//        System.out.println("v1="+v1+" v2="+v2);
//        v3=v1.mul(v2);
//        print(v3);
//
//        v1=new VarD(-6);
//        v2=new VarD(12);
//        System.out.println("v1="+v1+" v2="+v2);
//        v3=v1.add(v2);
//        print(v3);
//
//        v1=new VarD(-7);
//        v2=new VarD(3.1);
//        System.out.println("v1="+v1+" v2="+v2);
//        v3=v1.mul(v2);
//        print(v3);
//
//        v1=new VarD(-4);
//        v2=new VarD(8);
//        System.out.println("v1="+v1+" v2="+v2);
//        v3=v1.div(v2);
//        print(v3);
//
//        v1=new VarD(-9);
//        v2=new VarD(0.9);
//        System.out.println("v1="+v1+" v2="+v2);
//        v3=v1.sub(v2);
//        print(v3);
//
//        v1=new VarV("{2,3,4}");
//        v2=new VarD("2");
//        System.out.println("vec1="+v1+" d2="+v2);
//        v3=v1.add(v2);
//        print(v3);
//
//        v1=new VarV("{2,3,4}");
//        v2=new VarD("3");
//        System.out.println("vec1="+v1+" d2="+v2);
//        v3=v1.div(v2);
//        print(v3);
//
//        v1=new VarV("{2,3,4}");
//        v2=new VarD("5");
//        System.out.println("vec1="+v1+" d2="+v2);
//        v3=v1.sub(v2);
//        print(v3);
//
//        v1=new VarD("-4");
//        v2=new VarV("{2,3,4}");
//        System.out.println("d1="+v1+" vec2="+v2);
//        v3=v1.add(v2);
//        print(v3);
//
//        v1=new VarV("{2,3,4}");
//        v2=new VarV("{5,6,7}");
//        System.out.println("vec1="+v1+" vec2="+v2);
//        v3=v1.add(v2);
//        print(v3);
//
//        v1=new VarV("{2,3,4}");
//        v2=new VarV("{5,6,7}");
//        System.out.println("vec1="+v1+" vec2="+v2);
//        v3=v1.sub(v2);
//        print(v3);
//
//        v1=new VarM("{{1,2},{8,3}}");
//        v2=new VarD("2");
//        System.out.println("mat1="+v1+" d2="+v2);
//        v3=v1.sub(v2);
//        print(v3);
//
//        v1=new VarM("{{1,2},{8,3}}");
//        v2=new VarV("{1,2}");
//        System.out.println("mat1="+v1+" vec2="+v2);
//        v3=v1.mul(v2);
//        print(v3);
//
//
//        v1=new VarM("{{1,2},{8,3}}");
//        v2=new VarM("{{1,2},{8,3}}");
//        System.out.println("mat1="+v1+" mat2="+v2);
//        v3=v1.mul(v2);
//        print(v3);
//
//        v1=new VarM("{{1,2},{8,3}}");
//        v2=new VarM("{{1,2},{8,3}}");
//        System.out.println("mat1="+v1+" mat2="+v2);
//        v3=v1.add(v2);
//        print(v3);
//
//    }
}
