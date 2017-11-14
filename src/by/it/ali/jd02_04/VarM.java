package by.it.ali.jd02_04;

public class VarM extends Var implements Str {
    public String value;
    VarM(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return new String(value);
    }

    @Override
    public Var add(Var x){
        if (x instanceof VarD)
            return new VarM("Здесь происходит сложение матрицы с числом");
        else if (x instanceof VarV)
            return new VarM("Здесь происходит сложение матрицы с вектором");
        else if (x instanceof VarM)
            return new VarM("Здесь происходит сложение матрицы с матрицей");
        else
            return null;
    }

    @Override
    public Var sub(Var x){
        if (x instanceof VarD)
            return new VarM("Здесь происходит вычитание числа из матрицы");
        else if (x instanceof VarV)
            return new VarM("Здесь происходит вычитание вектора из матрицы");
        else if (x instanceof VarM)
            return new VarM("Здесь происходит вычитание матрицы из матрицы");
        else
            return null;
    }
    @Override
    public Var mul(Var x){
        if (x instanceof VarD)
            return new VarM("Здесь происходит умножение матрицы с числом");
        else if (x instanceof VarV)
            return new VarM("Здесь происходит умножение матрицы с вектором");
        else if (x instanceof VarM)
            return new VarM("Здесь происходит умножение матрицы на матрицу");
        else
            return null;
    }

    @Override
    public Var div(Var x){
        if (x instanceof VarD)
            return new VarM("Здесь происходит деление матрицы на число");
        else
            return null;
    }
}
