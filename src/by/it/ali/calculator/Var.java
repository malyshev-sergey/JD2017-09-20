package by.it.ali.calculator;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Func{

    static private Map<String, Var> mapvar=new HashMap<>();

    static void saveVar(String name, Var value){
        mapvar.put(name,value);
    }
    @Override
    public Var add(Var x) {
        System.out.println("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub(Var x) {
        System.out.println("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var x) {
        System.out.println("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var x) {
        System.out.println("Деление невозможно");
        return null;
    }
}