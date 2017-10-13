package by.it.shelkovich.calc;

public class CalcRunner {
    public static void main(String[] args) {

        Var v1 = new VarD(1.5);
        Var v2 = new VarD(1.5);
        Var v3 = new VarV("");
        Var v4 = new VarM("");

        //v1.sub(v2);
        //v1.mul(v3);
        v1.div(v3);
        //v4.add(v3);
        //v4.mul(v3);

        //System.out.println(v1.getClass().getCanonicalName());

        /*Var v1 = new VarD(1.5);
        VarD v3 = new VarD(1.5);
        Var v2 = new VarV("");
        v1.add(v2);*/


        //System.out.println(v1.getClass());
    }
}
