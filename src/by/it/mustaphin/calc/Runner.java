package by.it.mustaphin.calc;

public class Runner {
    public static void main(String[] args) {
        VarD varD1 = new VarD(4);
        VarD varD2 = new VarD(6);
        System.out.println(varD2.add(varD1));
        System.out.println(varD2.div(varD1));
        System.out.println(varD2.mul(varD1));
        System.out.println(varD2.sub(varD1));
        System.out.println("=========================");
        VarV varV1 = new VarV(new double[]{1.8, 2.7, 3.6, 4.5});
        VarV varV2 = new VarV(new double[]{2.0, 3.0, 4.0, 5.0});
        System.out.println(varV1.add(varV2));
        System.out.println(varV1.div(varV2));
        System.out.println(varV1.mul(varV2));
        System.out.println(varV1.sub(varV2));
        System.out.println("=========================");
        System.out.println(varD1.add(varV2));
        System.out.println(varD1.div(varV2));
        System.out.println(varD1.mul(varV2));
        System.out.println(varD1.sub(varV2));
        System.out.println("=========================");
        System.out.println(varV1.add(varD2));
        System.out.println(varV1.div(varD2));
        System.out.println(varV1.mul(varD2));
        System.out.println(varV1.sub(varD2));
    }
}
