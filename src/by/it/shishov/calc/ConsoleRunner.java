package by.it.shishov.calc;

/**
 * Created by Сергей on 11.10.2017.
 */
public class ConsoleRunner {
    public static void main(String[] args) {
        VarD x = new VarD(4);
        VarD y = new VarD(12.45);
        System.out.println(x +"/" + y + "="+x.div(y));

        Var v1=new VarV("{3,7,22}");
        Var v2=new VarD("9");
        System.out.println("vec1="+v1+" d2="+v2);
        Var v3=v1.mul(v2);
        System.out.println(v3);
    }
}
