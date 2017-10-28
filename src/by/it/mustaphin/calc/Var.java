package by.it.mustaphin.calc;

class Var implements MathOperations, Variable {

    Var var = null;

    @Override
    public Var add(Var var) {
        try {
            throw new MathException("Сложение не возможно");
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Var sub(Var var) {
        try {
            throw new MathException("Вычитние не возможно");
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Var mul(Var var) {
        try {
            throw new MathException("Умножение не возможно");
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Var div(Var var) {
        try {
            throw new MathException("Деление не возможно");
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void assignment(String name, Var var) {
        StoreData.store(name, var);
    }

    @Override
    public void fromString(String str) {
        if (str.contains("{{")) {
            var = new VarM(str);
        } else if (str.contains("{")) {
            var = new VarV(str);
        } else{
            var = new VarD(str);
        }
    }

    public Var getVar(String str) {
        fromString(str);
        return var;
    }
}
