package by.it.dubrova.calc2;

public class VarV extends Var implements IOperation, IVariable {
    public double value[];

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


}
