package by.it.dubrova.calc2;

public class VarV extends Var implements IOperation, IVariable {
    private double value[];
    private double result; // переменная для храниения мат результата

    @Override
    public void fromString(String value) {
        value = value.substring(1,value.length()-1); // обрезаем {}
        String line[] = value.split(","); // разбиваем на массив
        int start = 0;
        this.value = new double[line.length];
        for (String s : line){
            this.value[start++] = Double.parseDouble(s);
        }
    }

    // привести к строке наш результат
    public String toString(){
        return Double.toString(result);
    }

/////////////////////////////////////
    // Возможно математику я выполнил не верно!!!!
/////////////////////////////////////
    public Var add(Var var) {
        // Это наш VarD
        this.result = 0;
        double tmp = ((VarD)var).getValue();
        for (double d : this.value){
            this.result += d * tmp;
        }

        return (VarV)this;
    }

    public Var sub(Var var) {
        // Это наш VarD
        this.result = 0;
        double tmp = ((VarD)var).getValue();
        for (double d : this.value){
            this.result -= d * tmp;
        }

        return (VarV)this;
    }

    public Var mul(Var var) {
        // Это наш VarD
        this.result = 0;
        double tmp = ((VarD)var).getValue();
        for (double d : this.value){
            this.result *= d * tmp;
        }

        return (VarV)this;
    }

    public Var div(Var var) {
        // Это наш VarD
        this.result = 0;
        double tmp = ((VarD)var).getValue();
        for (double d : this.value){
            this.result /= d * tmp;
        }

        return (VarV)this;
    }

}
