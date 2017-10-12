package by.it.shelkovich.calc;

public class VarD extends Var{
    private Double value;

    double getValue(){
        return value;
    }

    VarD(String value) {
        this(Double.parseDouble(value));
    }
    VarD(double value) {
        this.value = value;
    }





}
