package by.it.shelkovich.calc;

public class VarM extends Var {
    private double[][] value;
    double[][] getValue(){
        return value;
    }

    VarM(String value) {
        //this.value = Double.parseDouble(value);
    }
    VarM(double[][] value) {
        this.value = value;
    }

    public VarM add(VarD arg) {
        System.out.println("сложение матрицы с числом");
        return new VarM("");
    }

    public VarM mul(VarD arg) {
        System.out.println("Умножение матрицы на число");
        return new VarM("");
    }

    public VarM sub(VarD arg) {
        System.out.println("Разность матрицы с числом");
        return new VarM("");
    }

    public VarM div(VarD arg) {
        System.out.println("Деление матрицы на число");
        return new VarM("");
    }



    public VarM mul(VarV arg) {
        System.out.println("Умножение матрицы на вектор");
        return new VarM("");
    }


    public VarM add(VarM arg) {
        System.out.println("сложение матрицы с матрицей");
        return new VarM("");
    }

    public VarM mul(VarM arg) {
        System.out.println("Умножение матрицы на матрицу");
        return new VarM("");
    }

    @Override
    public Var defaultAdd(Var v) {
        if (!v.isUsed()){
            used = true;
            return v.add(this);
        }else
            return null;

    }

    @Override
    public Var defaultMul(Var v) {
        if (!v.isUsed()){
            used = true;
            return v.mul(this);
        }else
            return null;
    }

}
