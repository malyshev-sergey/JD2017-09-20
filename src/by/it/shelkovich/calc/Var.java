package by.it.shelkovich.calc;

public abstract class Var<T> implements IAdd, IMul, ISub, IDiv {
    protected boolean used = false;

    protected boolean printed = false;

    boolean isUsed() {
        return used;
    }

    void setUsed(boolean used) {
        this.used = used;
    }

    Var getVar() {
        return this;
    }

    void printErr(String err){
        if (!printed && !used) {
            System.out.printf("Операция %s невозможна\n", err);
            printed = true;
        } else if(printed) printed = false;
    }

    private Var defaultWrap(String type, String errType, Var v, boolean recall){
        Var result;
        if (!recall) result = defaultOp(type, v, true);
        else result = recall(type, v);
        used = false;
        if (result != null){
            return result;
        }
        else {
            printErr(errType);
            return null;
        }
    }

    Var defaultOp(String type, Var v, boolean setUsed){
        return null;
    }


    public Var recall(String op, Var v){
        return v.defaultOp(op, this, false);
    }

    //########################################.Сложение.##################################################

    @Override
    public Var add(VarD v1) {
        return defaultWrap("add", "сложения", v1, false);
    }

    @Override
    public final Var add(Var v1) {
        return defaultWrap("add", "сложения", v1, true);
    }

    @Override
    public Var add(VarV v1) {
        return defaultWrap("add", "сложения", v1, false);
    }

    @Override
    public Var add(VarM v1) {
        return defaultWrap("add", "сложения", v1, false);
    }


    //########################################.Умножение.##################################################
    @Override
    public Var mul(VarD v1) {
        return defaultWrap("mul", "умножения", v1, false);
    }

    @Override
    public final Var mul(Var v1) {
        return defaultWrap("mul", "умножения", v1, true);
    }

    @Override
    public Var mul(VarV v1) {
        return defaultWrap("mul", "умножения", v1, false);
    }

    @Override
    public Var mul(VarM v1) {
        return defaultWrap("mul", "умножения", v1, false);
    }

    //########################################.Разность.##################################################
    @Override
    public Var sub(VarD v1) {
        return defaultWrap("sub", "разности", v1, false);
    }

    @Override
    public final Var sub(Var v1) {
        return defaultWrap("sub", "разности", v1, true);
        /*Var result;
        if (!used) {
            v1.setUsed(true);
            result = v1.sub(this);
        } else result = defaultOp("sub", v1);

        if (result != null) return result;
        else {
            printErr("разности");
            return null;
        }*/
    }

    @Override
    public Var sub(VarV v1) {
        return defaultWrap("sub", "разности", v1, false);
    }

    @Override
    public Var sub(VarM v1) {
        return defaultWrap("sub", "разности", v1, false);
    }

    //########################################.Деление.##################################################
    @Override
    public Var div(VarD v1) {
        return defaultWrap("div", "деления", v1, false);
    }

    @Override
    public final Var div(Var v1) {
        return defaultWrap("div", "деления", v1, true);
        /*Var result;
        if (!used) {
            v1.setUsed(true);
            result = v1.div(this);
        } else result = defaultOp("div",v1);

        if (result != null) return result;
        else {
            printErr("деления");
            return null;
        }*/
    }

    @Override
    public Var div(VarV v1) {
        return defaultWrap("div", "деления", v1, false);
    }

    @Override
    public Var div(VarM v1) {
        return defaultWrap("div", "деления", v1, false);
    }


}
