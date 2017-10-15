package by.it.halai.calculator_v1;

/**
 * @author Vitaly Halai
 */
public class Runner {

    private static void print(Var v) {

        if (v != null) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {

        //Пример А.1.
        System.out.println("Пример А.1.");
        Var v1 = new VarD(3.8);
        Var v2 = new VarD(26.2);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Сложение");
        Var v3 = v1.add(v2);
        print(v3);

        //Пример А.2.
        System.out.println("Пример А.2.");
        v1 = new VarD(87.4);
        v2 = new VarD(23.1);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        v3 = v1.subtraction(v2);
        print(v3);

        //Пример А.3.
        System.out.println("Пример А.3.");
        v1 = new VarD(1.04);
        v2 = new VarD(5.9);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Умножение");
        v3 = v1.multiplication(v2);
        print(v3);

        //Пример А.4.
        System.out.println("Пример А.4.");
        v1 = new VarD(-6);
        v2 = new VarD(12);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Сложение");
        v3 = v1.add(v2);
        print(v3);

        //Пример А.5.
        System.out.println("Пример А.5.");
        v1 = new VarD(-3);
        v2 = new VarD(3.1);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Умножение");
        v3 = v1.multiplication(v2);
        print(v3);

        //Пример А.6.
        System.out.println("Пример А.6.");
        v1 = new VarD(-4);
        v2 = new VarD(8);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Деление");
        v3 = v1.division(v2);
        print(v3);

        //Пример А.7.
        System.out.println("Пример А.7.");
        v1 = new VarD(-9);
        v2 = new VarD(0.9);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        v3 = v1.subtraction(v2);
        print(v3);

        //Пример В.1.
        System.out.println("Пример B.1.");
        v1 = new VarV("2,3,4");
        v2 = new VarD(2);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Умножение");
        v3 = v1.multiplication(v2);
        print(v3);

        //Пример В.2.
        System.out.println("Пример B.2.");
        v1 = new VarV("2,3,4");
        v2 = new VarD(3);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Деление");
        v3 = v1.division(v2);
        print(v3);

        //Пример В.3.
        System.out.println("Пример B.3.");
        v1 = new VarV("2,3,4");
        v2 = new VarD(5);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        v3 = v1.subtraction(v2);
        print(v3);

        //Пример В.4.
        System.out.println("Пример B.4.");
        double[] v = {2, 3, 4};
        v1 = new VarD(-4);
        v2 = new VarV(v);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Сложение");
        v3 = v1.add(v2);
        print(v3);

        //Пример В.5.
        System.out.println("Пример B.5.");
        double[] i = {2, 3, 4};
        double[] j = {5, 6, 7};
        v1 = new VarV(i);
        v2 = new VarV(j);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Сложение");
        v3 = v1.add(v2);
        print(v3);

        //Пример В.6.
        System.out.println("Пример B.6.");
        i = new double[]{2, 3, 4};
        j = new double[]{5, 6, 7};
        v1 = new VarV(i);
        v2 = new VarV(j);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        v3 = v1.subtraction(v2);
        print(v3);

        //Пример C.1.
        System.out.println("Пример C.1.");
        double[][] a = {{1, 2}, {8, 3}};
        v1 = new VarM(a);
        v2 = new VarD(2);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        v3 = v1.subtraction(v2);
        print(v3);

        //Пример C.2.
        System.out.println("Пример C.2.");
        a = new double[][]{{1, 2}, {8, 3}};
        i = new double[]{1, 2};
        v1 = new VarM(a);
        v2 = new VarV(i);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Умножение");
        v3 = v1.multiplication(v2);
        print(v3);

        //Пример C.3.
        System.out.println("Пример C.3.");
        a = new double[][]{{1, 2}, {8, 3}};
        v1 = new VarM(a);
        v2 = new VarM(a);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Умножение");
        v3 = v1.multiplication(v2);
        print(v3);

        //Пример C.4.
        System.out.println("Пример C.4.");
        a = new double[][]{{1, 2}, {8, 3}};
        v1 = new VarM(a);
        v2 = new VarM(a);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Сложение");
        v3 = v1.add(v2);
        print(v3);


    }
}
