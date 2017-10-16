package by.it.halai.calculator_v2;

/**
 * @author Vitaly Halai
 */
public class ConsoleRunner {

    private static void print(Var v) {

        if (v != null) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {

        //Пример А.1.
        System.out.println("Пример А.1.");
        VarD v1 = new VarD(3.8);
        VarD v2 = new VarD(26.2);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Сложение");
        print(new ADD().add(v1, v2));


        //Пример А.2.
        System.out.println("Пример А.2.");
        v1 = new VarD(87.4);
        v2 = new VarD(23.1);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        print(new Subtraction().subtraction(v1, v2));

        //Пример А.3.
        System.out.println("Пример А.3.");
        v1 = new VarD(1.04);
        v2 = new VarD(5.9);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Умножение");
        print(new Multiplication().multiplication(v1, v2));

        //Пример А.4.
        System.out.println("Пример А.4.");
        v1 = new VarD(-6);
        v2 = new VarD(12);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Сложение");
        print(new ADD().add(v1, v2));

        //Пример А.5.
        System.out.println("Пример А.5.");
        v1 = new VarD(-3);
        v2 = new VarD(3.1);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Умножение");
        print(new Multiplication().multiplication(v1, v2));

        //Пример А.6.
        System.out.println("Пример А.6.");
        v1 = new VarD(-4);
        v2 = new VarD(8);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Деление");
        print(new Division().division(v1, v2));

        //Пример А.7.
        System.out.println("Пример А.7.");
        v1 = new VarD(-9);
        v2 = new VarD(0.9);
        System.out.println("v1 = " + v1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        print(new Subtraction().subtraction(v1, v2));

        //Пример В.1.
        System.out.println("Пример B.1.");
        VarV vv1 = new VarV("2,3,4");
        v2 = new VarD(2);
        System.out.println("v1 = " + vv1 + "; v2 = " + v2);
        System.out.println("Умножение");
        print(new Multiplication().multiplication(vv1, v2));

        //Пример В.2.
        System.out.println("Пример B.2.");
        vv1 = new VarV("2,3,4");
        v2 = new VarD(3);
        System.out.println("v1 = " + vv1 + "; v2 = " + v2);
        System.out.println("Деление");
        print(new Division().division(vv1, v2));

        //Пример В.3.
        System.out.println("Пример B.3.");
        vv1 = new VarV("2,3,4");
        v2 = new VarD(5);
        System.out.println("v1 = " + vv1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        print(new Subtraction().subtraction(vv1, v2));

        //Пример В.4.
        System.out.println("Пример B.4.");
        double[] v = {2, 3, 4};
        v1 = new VarD(-4);
        vv1 = new VarV(v);
        System.out.println("v1 = " + v1 + "; v2 = " + vv1);
        System.out.println("Сложение");
        print(new ADD().add(v1, vv1));

        //Пример В.5.
        System.out.println("Пример B.5.");
        double[] i = {2, 3, 4};
        double[] j = {5, 6, 7};
        vv1 = new VarV(i);
        VarV vv2 = new VarV(j);
        System.out.println("v1 = " + vv1 + "; v2 = " + vv2);
        System.out.println("Сложение");
        print(new ADD().add(vv1, vv2));

        //Пример В.6.
        System.out.println("Пример B.6.");
        i = new double[]{2, 3, 4};
        j = new double[]{5, 6, 7};
        vv1 = new VarV(i);
        vv2 = new VarV(j);
        System.out.println("v1 = " + vv1 + "; v2 = " + vv2);
        System.out.println("Вычитание");
        print(new Subtraction().subtraction(vv1, vv2));

        //Пример C.1.
        System.out.println("Пример C.1.");
        double[][] a = {{1, 2}, {8, 3}};
        VarM vm1 = new VarM(a);
        v2 = new VarD(2);
        System.out.println("v1 = " + vm1 + "; v2 = " + v2);
        System.out.println("Вычитание");
        print(new Subtraction().subtraction(vm1, v2));

        //Пример C.2.
        System.out.println("Пример C.2.");
        a = new double[][]{{1, 2}, {8, 3}};
        i = new double[]{1, 2};
        vm1 = new VarM(a);
        vv2 = new VarV(i);
        System.out.println("v1 = " + vm1 + "; v2 = " + vv2);
        System.out.println("Умножение");
        print(new Multiplication().multiplication(vm1, vv2));

        //Пример C.3.
        System.out.println("Пример C.3.");
        a = new double[][]{{1, 2}, {8, 3}};
        vm1 = new VarM(a);
        VarM vm2 = new VarM(a);
        System.out.println("v1 = " + vm1 + "; v2 = " + vm2);
        System.out.println("Умножение");
        print(new Multiplication().multiplication(vm1, vm2));

        //Пример C.4.
        System.out.println("Пример C.4.");
        a = new double[][]{{1, 2}, {8, 3}};
        vm1 = new VarM(a);
        vm2 = new VarM(a);
        System.out.println("v1 = " + vm1 + "; v2 = " + vm2);
        System.out.println("Сложение");
        print(new ADD().add(vm1, vm2));
    }
}
