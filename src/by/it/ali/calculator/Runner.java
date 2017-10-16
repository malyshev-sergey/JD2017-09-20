package by.it.ali.calculator;

public class Runner {

    public static void main(String[] args) {
    Var v1 = new VarD(3.4);
    Var v2 = new VarD(3.0);
    System.out.println("v1="+v1+" v2="+v2);
    Var v3 = v1.add(v2);
    Var v4 = v1.sub(v2);
    Var v5 = v1.mul(v2);
    Var v6 = v1.div(v2);
        System.out.println("v1+v2="+v3+" v1-v2="+v4+" v1*v2="+v5+" v1/v2="+v6);
    }
}
