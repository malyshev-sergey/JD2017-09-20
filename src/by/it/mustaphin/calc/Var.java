package by.it.mustaphin.calc;

abstract class Var implements MathOperations, Variable {

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

    static Var getVar(String str) {
        if (str.contains("{{")) {
            return new VarM(str);
        } else if (str.contains("{")) {
            return new VarV(str);
        } else {
            return new VarD(str);
        }
    }

}
