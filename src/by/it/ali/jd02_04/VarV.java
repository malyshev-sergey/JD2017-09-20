package by.it.ali.jd02_04;


//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class VarV extends Var implements Str {
    public String value;
    VarV(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return new String(value);
    }
    @Override
    public Var add(Var x){
        if (x instanceof VarD)
            return new VarV("Здесь происходит сложение вектора с числом");
        else if (x instanceof VarV)
            return new VarV("Здесь происходит сложение вектора с вектором");
        else if (x instanceof VarM)
            return new VarM("Здесь происходит сложение вектора с матрицей");
        else
            return x.add(this);
    }

    @Override
    public Var sub(Var x){
        if (x instanceof VarD)
            return new VarV("Здесь происходит вычитание числа из вектора");
        else if (x instanceof VarV)
            return new VarV("Здесь происходит вычитание вектора из вектора");
        else
            return x.sub(this);
    }
    @Override
    public Var mul(Var x){
        if (x instanceof VarD)
            return new VarV("Здесь происходит умножение числа с вектором");
        else if (x instanceof VarV)
            return new VarV("Здесь происходит умножение вектора с вектором");
        else if (x instanceof VarM)
            return new VarM("Здесь происходит умножение вектора на матрицу");
        else
            return x.mul(this);
    }
    @Override
    public Var div(Var x){
        if (x instanceof VarD)
            return new VarV("Здесь происходит деление вектора на число");
        else if (x instanceof VarV)
            return new VarV("Здесь происходит деление вектора на вектор");
        else
            return x.div(this);
    }
}
