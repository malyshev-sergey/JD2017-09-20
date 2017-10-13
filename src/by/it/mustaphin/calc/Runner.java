package by.it.mustaphin.calc;

public class Runner {
    public static void main(String[] args) {
        VarD varD1 = new VarD(4);
        VarD varD2 = new VarD(6);
        System.out.println("Операции со скаларными величинами");
        System.out.println(varD2.add(varD1));
        System.out.println(varD2.div(varD1));
        System.out.println(varD2.mul(varD1));
        System.out.println(varD2.sub(varD1));
        System.out.println("=========================");
        VarV varV1 = new VarV(new double[]{1.8, 2.7, 3.6, 4.5});
        VarV varV2 = new VarV(new double[]{2.0, 3.0, 4.0, 5.0});
        System.out.println("Операции с векторами");
        System.out.println(varV1.add(varV2));
        System.out.println(varV1.div(varV2));
        System.out.println(varV1.mul(varV2));
        System.out.println(varV1.sub(varV2));
        System.out.println("=========================");
        System.out.println("Операции со скаларными величинами и с векторами");
        System.out.println(varD1.add(varV2));
        System.out.println(varD1.div(varV2));
        System.out.println(varD1.mul(varV2));
        System.out.println(varD1.sub(varV2));
        System.out.println("=========================");
        System.out.println("Операции с векторами и со скаларными величинами");
        System.out.println(varV1.add(varD2));
        System.out.println(varV1.div(varD2));
        System.out.println(varV1.mul(varD2));
        System.out.println(varV1.sub(varD2));
        System.out.println("=========================");
        VarM varM1 = new VarM(new double[][]{{1, 2, 3}, {5, 6, 7}});
        VarM varM2 = new VarM(new double[][]{{5, 6, 7}, {8, 9, 11}});
        System.out.println("Операции с матрицами");
        System.out.println(varM1.add(varM2));
        System.out.println(varM1.div(varM2));
        System.out.println(varM1.mul(varM2));
        System.out.println(varM1.sub(varM2));
        System.out.println("=========================");
        System.out.println("Операции с матрицами и с векторами");
        System.out.println(varM1.add(varV2));
        System.out.println(varM1.div(varV1));
        System.out.println(varM1.mul(varV2));
        System.out.println(varM1.sub(varV1));
        System.out.println("=========================");
        System.out.println("Операции с матрицами и со скаларными величинами");
        System.out.println(varM1.add(varD1));
        System.out.println(varM1.div(varD2));
        System.out.println(varM1.mul(varD1));
        System.out.println(varM1.sub(varD2));
    }
}
