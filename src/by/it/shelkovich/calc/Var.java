package by.it.shelkovich.calc;

public abstract class Var implements IAdd, IMul, ISub, IDiv {
    protected boolean used = false;

    boolean isUsed() {
        return used;
    }

    //########################################.Сложение.##################################################
    @Override
    public Var add(VarD v1) {
        Var result = defaultAdd(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция сложения невозможна");
            return null;
        }
    }

    @Override
    public Var add(Var v1) {
        Var result = defaultAdd(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция сложения невозможна");
            return null;
        }
    }

    @Override
    public Var add(VarV v1) {
        Var result = defaultAdd(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция сложения невозможна");
            return null;
        }
    }

    @Override
    public Var add(VarM v1) {
        Var result = defaultAdd(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция сложения невозможна");
            return null;
        }
    }

    Var defaultAdd(Var v) {
        return null;
    }

    //########################################.Умножение.##################################################
    @Override
    public Var mul(VarD v1) {
        Var result = defaultMul(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция умножения невозможна");
            return null;
        }
    }

    @Override
    public Var mul(Var v1) {
        Var result = defaultMul(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция умножения невозможна");
            return null;
        }
    }

    @Override
    public Var mul(VarV v1) {
        Var result = defaultMul(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция умножения невозможна");
            return null;
        }
    }

    @Override
    public Var mul(VarM v1) {
        Var result = defaultMul(v1);
        if (result != null) return result;
        else {
            if (!used) System.out.println("Операция умножения невозможна");
            return null;
        }
    }

    Var defaultMul(Var v) {
        return null;
    }

    //########################################.Разность.##################################################
    @Override
    public Var sub(VarD v1) {
        if (!used) System.out.println("Операция разности невозможна");
        return null;
    }

    @Override
    public Var sub(Var v1) {
        if (!used) System.out.println("Операция разности невозможна");
        return null;
    }

    @Override
    public Var sub(VarV v1) {
        if (!used) System.out.println("Операция разности невозможна");
        return null;
    }

    @Override
    public Var sub(VarM v1) {
        if (!used) System.out.println("Операция разности невозможна");
        return null;
    }

    //########################################.Деление.##################################################
    @Override
    public Var div(VarD v1) {
        if (!used) System.out.println("Операция деления невозможна");
        return null;
    }

    @Override
    public Var div(Var v1) {
        if (!used) System.out.println("Операция деления невозможна");
        return null;
    }

    @Override
    public Var div(VarV v1) {
        if (!used) System.out.println("Операция деления невозможна");
        return null;
    }

    @Override
    public Var div(VarM v1) {
        if (!used) System.out.println("Операция деления невозможна");
        return null;
    }

}
