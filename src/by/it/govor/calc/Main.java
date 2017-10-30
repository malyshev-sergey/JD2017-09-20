package by.it.govor.calc;

public class Main {
    public Main() {
    }

    private static void print(Var v) {
        if(v != null) {
            System.out.println(v);
        }

    }

    public static void main(String[] args) {
        String vector = "{1,2,3}";
        String mat = "{{7,2,43},{4,7.8,6,81},{5,7,35.1}}";
        VarD v1 = new VarD(3.8);
        VarD v2 = new VarD(26.2);
        System.out.println("v1=" + v1 + " v2=" + v2);
        Var v3 = v1.add(v2);
        print(v3);

        // V V
        System.out.println("\nпроверка  +-*/ операций с двумя векторами");
        print(new VarV(vector).add(new VarV(vector)));
        print(new VarV(vector).sub(new VarV(vector)));
        print(new VarV(vector).mul(new VarV(vector)));
        print(new VarV(vector).div(new VarV(vector)));

        // M V
        System.out.println("\nпроверка  +-*/ операций с матрицей справа и вектором слева");
        print(new VarM(mat).add(new VarV(vector)));
        print(new VarM(mat).sub(new VarV(vector)));
        print(new VarM(mat).mul(new VarV(vector)));
        print(new VarM(mat).div(new VarV(vector)));

        // V M
        System.out.println("\nпроверка  +-*/ операций с вектором справа и матрицей слева");
        print(new VarV(vector).add(new VarM(mat)));
        print(new VarV(vector).sub(new VarM(mat)));
        print(new VarV(vector).mul(new VarM(mat)));
        print(new VarV(vector).div(new VarM(mat)));

        // M M
        System.out.println("\nпроверка  +-*/ операций с двумя матрицами");
        print(new VarM(mat).add(new VarM(mat)));
        print(new VarM(mat).sub(new VarM(mat)));
        print(new VarM(mat).mul(new VarM(mat)));
        print(new VarM(mat).div(new VarM(mat)));


    }
}
