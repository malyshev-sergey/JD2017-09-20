package by.it.shelkovich.calc;

public class CalcRunner {
    public static void main(String[] args) {
        
        System.out.println("Оперции с числами");
        System.out.println(((Var) new VarD("3.8")).add((Var) new VarD("26.2")).toString());
        System.out.println(new VarD("87.4").sub(new VarD("23.1")).toString());
        System.out.println(new VarD("1.04").mul(new VarD("5.9")).toString());
        System.out.println(new VarD("12.7").mul(new VarD("5")).toString());
        System.out.println(new VarD("-6").add(new VarD("12")).toString());
        System.out.println(new VarD("-7").mul(new VarD("3.1")).toString());
        System.out.println(new VarD("4").div(new VarD("8")).toString());
        System.out.println(new VarD("-9").sub(new VarD("0.9")).toString());

        System.out.println("\n\nОперации с векторами");

        System.out.println(((Var) new VarV("{2,3,4}")).mul((Var) new VarD("2")).toString());
        System.out.println(new VarV("{2,3,4}").div(new VarD("3")).toString());
        System.out.println(new VarV("{2,3,4}").sub(new VarD("5")).toString());
        System.out.println(((Var)new VarD("-4")).add((Var)new VarV("{2,3,4}")).toString());
        System.out.println(new VarV("{2,3,4}").add(new VarV("{5,6,7}")).toString());
        System.out.println(new VarV("{2,3,4}").sub(new VarV("{5,6,7}")).toString());

        System.out.println("\n\nОперации с матрицами");
        System.out.println(((Var) new VarM("{{1,2},{8,3}}")).sub((Var) new VarD("2")).toString());
        System.out.println(new VarM("{{1,2},{8,3}}").mul(new VarV("{1,2}")).toString());
        System.out.println(new VarM("{{1,2},{8,3}}").mul(new VarM("{{1,2},{8,3}}")).toString());
        System.out.println(new VarM("{{1,2},{8,3}}").add(new VarM("{{1,2},{8,3}}")).toString());
    }
}
