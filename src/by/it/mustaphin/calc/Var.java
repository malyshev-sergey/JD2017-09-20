package by.it.mustaphin.calc;

class Var implements MathOperations, Variable {

    Var var = null;

    @Override
    public Var add(Var var) {
        System.out.println("Сложение не возможно");
        return null;
    }

    @Override
    public Var sub(Var var) {
        System.out.println("Вычитние не возможно");
        return null;
    }

    @Override
    public Var mul(Var var) {
        System.out.println("Умножение не возможно");
        return null;
    }

    @Override
    public Var div(Var var) {
        System.out.println("Деление не возможно");
        return null;
    }

    public static void assignment(String name, Var var) {
        StoreData.store(name, var);
    }

    @Override
    public void fromString(String str) {
        if (str.contains("{{")) {
            var = new VarD(str);
        }
    }

    public Var getVar(String str) {
        fromString(str);
        return var;
    }
}
