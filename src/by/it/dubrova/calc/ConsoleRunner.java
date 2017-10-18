package by.it.dubrova.calc;


public class ConsoleRunner {

    private static void print(Var v){
        if (v != null) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {
        Var v1=new VarD(3.8);
        Var v2=new VarD(26.2);
        System.out.println("v1="+v1+" v2="+v2);
        Var v3=v1.add(v2);
        print(v3);

        v1=new VarV("{2,3,4}");
        v2=new VarD("2");
        System.out.println("vec1="+v1+" d2="+v2);
        v3=v1.add(v2);
        print(v3);
    }
}
